package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;
import model.Build;
import model.Skill;
import model.Specialization;
import model.Trait;
import org.jetbrains.annotations.Nullable;

import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileManager {

    private static FileManager fileManager;

    private FileManager() {
    }

    private synchronized static void createInstence() {
        if (fileManager == null) {
            fileManager = new FileManager();
        }
    }

    public static FileManager getInstance() {
        createInstence();
        return fileManager;
    }

    private final String SKILLS_IDS_PATH = "./SkillsIds.json";
    private final String SKILLS_PATH = "./Skills.json";
    private final String SKILL_URL = "https://api.guildwars2.com/v2/skills?ids=";
    private final String SPECIALIZATIONS_IDS_PATH = "./SpecializationsIds.json";
    private final String SPECIALIZATIONS_PATH = "./Specializations.json";
    private final String SPECIALIZATION_URL = "https://api.guildwars2.com/v2/specializations/";
    private final String TRAITS_IDS_PATH = "./TraitsIds.json";
    private final String TRAITS_PATH = "./Traits.json";
    private final String TRAIT_URL = "https://api.guildwars2.com/v2/traits/";
    private final String BUILDS_PATH = "./Builds/";
    private Gson gson;
    private File jsonFile;
    private ObjectMapper mapper;
    private final Map<String, Integer> ElementalistSpecializationIds = Map.of
            ("Water", 17, "Earth", 26, "Fire", 31, "Arcane", 37, "Air", 41,
                    "Tempest", 48, "Weaver", 56);

    private final Map<String, Integer> WarriorSpecializationIds = Map.of(
            "Strength", 4, "Tactics", 11, "Berserker", 18,
            "Defense", 22, "Arms", 36, "Discipline", 51, "Spellbreaker", 61);

    private final Map<String, Integer> RangerSpecializationIds = Map.of(
            "Druid", 5, "Marksmanship", 8, "Nature Magic", 25,
            "Skirmishing", 30, "Beastmastery", 32, "Wilderness Survival", 33, "Soulbeast", 55);

    private final Map<String, Integer> NecromancerSpecializationIds = Map.of
            ("Death Magic", 2, "Blood Magic", 19, "Reaper", 34, "Curses", 39,
                    "Soul Reaping", 50, "Spite", 53, "Scourge", 60);

    private final Map<String, Integer> GuardianSpecializationIds = Map.of(
            "Valor", 13, "Radiance", 16, "Dragonhunter", 27,
            "Zeal", 42, "Virtues", 46, "Honor", 49, "Firebrand", 62);

    private final Map<String, Integer> ThiefSpecializationIds = Map.of(
            "Daredevil", 7, "Shadow Arts", 20, "Deadly Arts", 28,
            "Critical Strikes", 35, "Trickery", 44, "Acrobatics", 54, "Deadeye", 58);

    private final Map<String, Integer> EngineerSpecializationIds = Map.of(
            "Explosives", 6, "Tools", 21, "Alchemy", 29,
            "Firearms", 38, "Scrapper", 43, "Inventions", 47, "Holosmith", 57);

    private final Map<String, Integer> MesmerSpecializationIds = Map.of
            ("Dueling", 1, "Domination", 10, "Inspiration", 23, "Illusions", 24,
                    "Chronomancer", 40, "Chaos", 45, "Mirage", 59);

    private final Map<String, Integer> RevenantSpecializationIds = Map.of
            ("Invocation", 3, "Retribution", 9, "Salvation", 12, "Corruption", 14,
                    "Devastation", 15, "Herald", 52, "Renegade", 63);

    private String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            Thread.sleep(150);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);
            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    /*SKILLS*/
    /*----------------------------------------------------------------------------------------------------------------*/

    private ArrayList<Number> readSkillsIdFromJson() throws FileNotFoundException {
        gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(SKILLS_IDS_PATH));
        return gson.fromJson(bufferedReader, ArrayList.class);
    }

    private List<String> getSkillsURL() throws FileNotFoundException {
        List<String> skillsUrls = new ArrayList<>();
        readSkillsIdFromJson().forEach(id -> skillsUrls.add(SKILL_URL + id.intValue()));
        return skillsUrls;
    }

    public void writeSkillsToJson() throws Exception {
        gson = new Gson();
        List<String> skillsURL = getSkillsURL();
        StringBuilder st = new StringBuilder();
        String jsonString;
        st.append("[");
        boolean isFirst = true;
        for (String skillURL : skillsURL) {
            System.out.println(skillURL);
            String url = readUrl(skillURL);
            url = url.substring(1, url.length() - 1);
            if (isFirst) {
                st.append(",");
                isFirst = false;
            }
            st.append(url);
        }
        st.append("]");
        jsonString = st.toString();
        Skill[] skillsArray = gson.fromJson(jsonString, Skill[].class);
        try (Writer writer = new FileWriter(SKILLS_PATH)) {
            gson = new GsonBuilder().create();
            gson.toJson(skillsArray, writer);
        }
    }

    public List<Skill> getSkillsFor(String profession, String weaponType, String weaponSlot, @Nullable String attunement) throws IOException {
        jsonFile = new File(SKILLS_PATH);
        mapper = new ObjectMapper();
        Configuration conf = Configuration.defaultConfiguration().addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
        Filter filter = filter(where("professions")
                .contains(profession)
                .and("weapon_type").is(weaponType)
                .and("slot").is(weaponSlot)
                .and("attunement").is(attunement)
        );
        List<Map<String, Object>> output = JsonPath.using(conf).parse(jsonFile).read("$[*][?]", filter);
        List<Skill> skillList = new ArrayList<>();
        output.forEach(object -> {
            Skill skill = mapper.convertValue(object, Skill.class);
            skillList.add(skill);
        });
        Collections.sort(skillList);

        return skillList;
    }

    public List<Skill> getElementalistAttunementSkills() throws IOException {
        List<String> attunementNames = Arrays.asList("Fire Attunement", "Water Attunement", "Air Attunement", "Earth Attunement");
        jsonFile = new File(SKILLS_PATH);
        mapper = new ObjectMapper();
        Filter filter = filter(where("professions")
                .contains("Elementalist")
                .and("name").in(attunementNames)
        );
        List<Map<String, Object>> output = JsonPath.parse(jsonFile).read("$[*][?]", filter);
        List<Skill> skillList = new ArrayList<>();
        output.forEach(object -> {
            Skill skill = mapper.convertValue(object, Skill.class);
            skillList.add(skill);
        });
        Collections.sort(skillList);
        return skillList;
    }

    public List<Skill> getUtilitySkillsFor(String profession) throws IOException {
        jsonFile = new File(SKILLS_PATH);
        mapper = new ObjectMapper();
        Filter filter = filter(where("professions")
                .contains(profession)
                .and("slot").is("Utility"));
        List<Map<String, Object>> output = JsonPath.parse(jsonFile).read("$[*][?]", filter);
        List<Skill> skillList = new ArrayList<>();
        output.forEach(object -> {
            Skill skill = mapper.convertValue(object, Skill.class);
            skillList.add(skill);
        });
        Collections.sort(skillList);
        return skillList;
    }

    public List<Skill> getHealingSkillsFor(String profession) throws IOException {
        jsonFile = new File(SKILLS_PATH);
        mapper = new ObjectMapper();
        Filter filter = filter(where("professions")
                .contains(profession)
                .and("type").is("Heal"));
        List<Map<String, Object>> output = JsonPath.parse(jsonFile).read("$[*][?]", filter);
        List<Skill> skillList = new ArrayList<>();
        output.forEach(object -> {
            Skill skill = mapper.convertValue(object, Skill.class);
            skillList.add(skill);
        });
        Collections.sort(skillList);
        return skillList;
    }

    public List<Skill> getEliteSkillsFor(String profession) throws IOException {
        jsonFile = new File(SKILLS_PATH);
        mapper = new ObjectMapper();
        Filter filter = filter(where("professions")
                .contains(profession)
                .and("slot").is("Elite"));
        List<Map<String, Object>> output = JsonPath.parse(jsonFile).read("$[*][?]", filter);
        List<Skill> skillList = new ArrayList<>();
        output.forEach(object -> {
            Skill skill = mapper.convertValue(object, Skill.class);
            skillList.add(skill);
        });
        Collections.sort(skillList);
        return skillList;
    }

    /*SPECIALIZATIONS*/
    /*----------------------------------------------------------------------------------------------------------------*/

    private ArrayList<Number> readSpecializationsIdFromJson() throws FileNotFoundException {
        gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(SPECIALIZATIONS_IDS_PATH));
        return gson.fromJson(bufferedReader, ArrayList.class);
    }

    private List<String> getSpecializationsURL() throws FileNotFoundException {
        List<String> specializationUrls = new ArrayList<>();
        readSpecializationsIdFromJson().forEach(id -> specializationUrls.add(SPECIALIZATION_URL + id.intValue()));
        return specializationUrls;
    }

    public void writeSpecializationsToJson() throws Exception {
        gson = new Gson();
        List<String> specializationsURL = getSpecializationsURL();
        StringBuilder st = new StringBuilder();
        String jsonString;
        st.append("[");
        int i = 0;
        for (String specializationURL : specializationsURL) {
            System.out.println(specializationURL);
            String url = readUrl(specializationURL);
            if (i != 0) {
                st.append(",");
            }
            st.append(url);
            i++;
        }
        st.append("]");
        jsonString = st.toString();
        System.out.println(jsonString);
        Specialization[] specializationsArray = gson.fromJson(jsonString, Specialization[].class);
        try (Writer writer = new FileWriter(SPECIALIZATIONS_PATH)) {
            gson = new GsonBuilder().create();
            gson.toJson(specializationsArray, writer);
        }
    }

    public List<Specialization> getSpecializationsForProfession(String profession) {
        List<Specialization> specializationList = new ArrayList<>();
        try {
            jsonFile = new File(SPECIALIZATIONS_PATH);
            mapper = new ObjectMapper();
            Filter filter = filter(where("profession")
                    .is(profession));
            List<Map<String, Object>> output = JsonPath.parse(jsonFile).read("$[*][?]", filter);
            output.forEach(object -> {
                Specialization specialization = mapper.convertValue(object, Specialization.class);
                specializationList.add(specialization);
            });
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return specializationList;
    }

    /*TRAITS*/
    /*----------------------------------------------------------------------------------------------------------------*/

    private ArrayList<Number> readTraitsIdFromJson() throws FileNotFoundException {
        gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(TRAITS_IDS_PATH));
        return gson.fromJson(bufferedReader, ArrayList.class);
    }

    private List<String> getTraitsURL() throws FileNotFoundException {
        List<String> traitsUrls = new ArrayList<>();
        readTraitsIdFromJson().forEach(id -> traitsUrls.add(TRAIT_URL + id.intValue()));
        return traitsUrls;
    }

    public void writeTraitsToJson() throws Exception {
        gson = new Gson();
        List<String> traitsURL = getTraitsURL();
        StringBuilder st = new StringBuilder();
        String jsonString;
        st.append("[");
        int i = 0;
        for (String traitURL : traitsURL) {
            System.out.println(traitURL);
            String url = readUrl(traitURL);
            if (i != 0) {
                st.append(",");
            }
            st.append(url);
            i++;
        }
        st.append("]");
        jsonString = st.toString();
        System.out.println(jsonString);
        Trait[] specializationsArray = gson.fromJson(jsonString, Trait[].class);
        try (Writer writer = new FileWriter(TRAITS_PATH)) {
            gson = new GsonBuilder().create();
            gson.toJson(specializationsArray, writer);
        }
    }

    public ArrayList<Trait> getTraitsForProfessionWithSpecialization(String profession, String specialization, int tier, String slot) throws IOException {
        jsonFile = new File(TRAITS_PATH);
        mapper = new ObjectMapper();
        int specializationId = switch (profession) {
            case "Elementalist" -> ElementalistSpecializationIds.get(specialization);
            case "Warrior" -> WarriorSpecializationIds.get(specialization);
            case "Ranger" -> RangerSpecializationIds.get(specialization);
            case "Necromancer" -> NecromancerSpecializationIds.get(specialization);
            case "Guardian" -> GuardianSpecializationIds.get(specialization);
            case "Thief" -> ThiefSpecializationIds.get(specialization);
            case "Engineer" -> EngineerSpecializationIds.get(specialization);
            case "Mesmer" -> MesmerSpecializationIds.get(specialization);
            case "Revenant" -> RevenantSpecializationIds.get(specialization);
            default -> -1;
        };
        Filter filter = filter(where("specialization")
                .is(specializationId)
                .and("tier")
                .is(tier)
                .and("slot")
                .is(slot)
        );
        List<Map<String, Object>> output = JsonPath.parse(jsonFile).read("$[*][?]", filter);
        ArrayList<Trait> traitList = new ArrayList<>();
        output.forEach(object -> {
            Trait trait = mapper.convertValue(object, Trait.class);
            traitList.add(trait);
        });
        return traitList;
    }

    /*BUILDS*/
    /*----------------------------------------------------------------------------------------------------------------*/

    public void writeBuildToFile(Build build, String name) throws IOException {
        File file = new File(BUILDS_PATH + name + ".dat");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(build);
        objectOutputStream.close();
    }

    public Build readBuildFile(String name) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(BUILDS_PATH + name));
        return (Build) objectInputStream.readObject();
    }

    public List<Build> readAllBuildFiles() {
        List<String> paths = new ArrayList<>();
        List<Build> builds = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(BUILDS_PATH))) {
            paths = walk.filter(Files::isRegularFile).map(Path::toString).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (paths.size() > 0) {
            paths.forEach(path -> {
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
                    builds.add((Build) objectInputStream.readObject());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
        }
        return builds;
    }

    public void writeBuildToXml(Build build, String path) throws FileNotFoundException {
        XStream xStream = new XStream();
        xStream.alias("Build", Build.class);
        xStream.toXML(build, new FileOutputStream(path + "\\" + build.getBuildName() + ".xml"));
    }

    public boolean readBuildFromXmlAndWriteToFile(String path) {
        XStream xStream = new XStream();
        xStream.alias("Build", Build.class);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Build build = (Build) xStream.fromXML(fileInputStream);
            try {
                if (buildNameAlreadyExists(build)) {
                    build.setBuildName(build.getBuildName() + "_2");
                }
                writeBuildToFile(build, build.getBuildName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (StreamException e) {
            return false;
        }
        return true;
    }

    private boolean buildNameAlreadyExists(Build build) {
        for (Build b : readAllBuildFiles()) {
            if (b.getBuildName().equals(build.getBuildName())) {
                return true;
            }
        }
        return false;
    }
}