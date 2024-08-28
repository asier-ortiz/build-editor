package model;

import util.methodsUtil;

import javax.swing.*;
import java.util.*;

public class ProfessionGenerator {

    public ProfessionGenerator() {
        generateProfessions();
    }

    private final List<Profession> professions = new ArrayList<>();

    private void generateProfessions() {

        Profession elementalist = new Profession("Elementalist", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/elementalist.png"), 25, 25));
        List<WeaponSet> elementalistWeaponSet = Arrays.asList(
                new WeaponSet(elementalist, new String[]{"Staff"}, getIconFor("staff")),
                new WeaponSet(elementalist, new String[]{"Dagger", "Dagger"}, getIconFor("dagger_dagger")),
                new WeaponSet(elementalist, new String[]{"Dagger", "Focus"}, getIconFor("dagger_focus")),
                new WeaponSet(elementalist, new String[]{"Scepter", "Dagger"}, getIconFor("scepter_dagger")),
                new WeaponSet(elementalist, new String[]{"Scepter", "Focus"}, getIconFor("scepter_focus"))
        );
        elementalist.setWeaponSets(elementalistWeaponSet);
        professions.add(elementalist);

        Profession warrior = new Profession("Warrior", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/warrior.png"), 25, 25));
        List<WeaponSet> warriorWeaponSet = Arrays.asList(
                new WeaponSet(warrior, new String[]{"Greatsword"}, getIconFor("greatsword")),
                new WeaponSet(warrior, new String[]{"Hammer"}, getIconFor("hammer")),
                new WeaponSet(warrior, new String[]{"Longbow"}, getIconFor("longbow")),
                new WeaponSet(warrior, new String[]{"Rifle"}, getIconFor("rifle")),
                new WeaponSet(warrior, new String[]{"Axe", "Axe"}, getIconFor("axe_axe")),
                new WeaponSet(warrior, new String[]{"Axe", "Mace"}, getIconFor("axe_mace")),
                new WeaponSet(warrior, new String[]{"Axe", "Sword"}, getIconFor("axe_sword")),
                new WeaponSet(warrior, new String[]{"Axe", "Shield"}, getIconFor("axe_shield")),
                new WeaponSet(warrior, new String[]{"Axe", "Warhorn"}, getIconFor("axe_warhorn")),
                new WeaponSet(warrior, new String[]{"Mace", "Axe"}, getIconFor("mace_axe")),
                new WeaponSet(warrior, new String[]{"Mace", "Mace"}, getIconFor("mace_mace")),
                new WeaponSet(warrior, new String[]{"Mace", "Sword"}, getIconFor("mace_sword")),
                new WeaponSet(warrior, new String[]{"Mace", "Shield"}, getIconFor("mace_shield")),
                new WeaponSet(warrior, new String[]{"Mace", "Warhorn"}, getIconFor("mace_warhorn")),
                new WeaponSet(warrior, new String[]{"Sword", "Axe"}, getIconFor("sword_axe")),
                new WeaponSet(warrior, new String[]{"Sword", "Mace"}, getIconFor("sword_mace")),
                new WeaponSet(warrior, new String[]{"Sword", "Sword"}, getIconFor("sword_sword")),
                new WeaponSet(warrior, new String[]{"Sword", "Shield"}, getIconFor("sword_shield")),
                new WeaponSet(warrior, new String[]{"Sword", "Warhorn"}, getIconFor("sword_warhorn"))
        );
        warrior.setWeaponSets(warriorWeaponSet);
        professions.add(warrior);

        Profession ranger = new Profession("Ranger", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/ranger.png"), 25, 25));
        List<WeaponSet> rangerWeaponSet = Arrays.asList(
                new WeaponSet(ranger, new String[]{"Greatsword"}, getIconFor("greatsword")),
                new WeaponSet(ranger, new String[]{"Longbow"}, getIconFor("longbow")),
                new WeaponSet(ranger, new String[]{"Shortbow"}, getIconFor("shortbow")),
                new WeaponSet(ranger, new String[]{"Axe", "Axe"}, getIconFor("axe_axe")),
                new WeaponSet(ranger, new String[]{"Axe", "Dagger"}, getIconFor("axe_dagger")),
                new WeaponSet(ranger, new String[]{"Axe", "Torch"}, getIconFor("axe_torch")),
                new WeaponSet(ranger, new String[]{"Axe", "Warhorn"}, getIconFor("axe_warhorn")),
                new WeaponSet(ranger, new String[]{"Sword", "Axe"}, getIconFor("sword_axe")),
                new WeaponSet(ranger, new String[]{"Sword", "Dagger"}, getIconFor("sword_dagger")),
                new WeaponSet(ranger, new String[]{"Sword", "Torch"}, getIconFor("sword_torch")),
                new WeaponSet(ranger, new String[]{"Sword", "Warhorn"}, getIconFor("sword_warhorn"))
        );
        ranger.setWeaponSets(rangerWeaponSet);
        professions.add(ranger);

        Profession necromancer = new Profession("Necromancer", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/necromancer.png"), 25, 25));
        List<WeaponSet> necromancerWeaponSet = Arrays.asList(
                new WeaponSet(necromancer, new String[]{"Staff"}, getIconFor("staff")),
                new WeaponSet(necromancer, new String[]{"Axe", "Dagger"}, getIconFor("axe_dagger")),
                new WeaponSet(necromancer, new String[]{"Axe", "Focus"}, getIconFor("axe_focus")),
                new WeaponSet(necromancer, new String[]{"Axe", "Warhorn"}, getIconFor("axe_warhorn")),
                new WeaponSet(necromancer, new String[]{"Dagger", "Dagger"}, getIconFor("dagger_dagger")),
                new WeaponSet(necromancer, new String[]{"Dagger", "Focus"}, getIconFor("dagger_focus")),
                new WeaponSet(necromancer, new String[]{"Dagger", "Warhorn"}, getIconFor("dagger_warhorn")),
                new WeaponSet(necromancer, new String[]{"Scepter", "Dagger"}, getIconFor("scepter_dagger")),
                new WeaponSet(necromancer, new String[]{"Scepter", "Focus"}, getIconFor("scepter_focus")),
                new WeaponSet(necromancer, new String[]{"Scepter", "Warhorn"}, getIconFor("scepter_warhorn"))
        );
        necromancer.setWeaponSets(necromancerWeaponSet);
        professions.add(necromancer);

        Profession guardian = new Profession("Guardian", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/guardian.png"), 25, 25));
        List<WeaponSet> guardianWeaponSet = Arrays.asList(
                new WeaponSet(guardian, new String[]{"Greatsword"}, getIconFor("greatsword")),
                new WeaponSet(guardian, new String[]{"Hammer"}, getIconFor("hammer")),
                new WeaponSet(guardian, new String[]{"Staff"}, getIconFor("staff")),
                new WeaponSet(guardian, new String[]{"Mace", "Focus"}, getIconFor("mace_focus")),
                new WeaponSet(guardian, new String[]{"Mace", "Shield"}, getIconFor("mace_shield")),
                new WeaponSet(guardian, new String[]{"Mace", "Torch"}, getIconFor("mace_torch")),
                new WeaponSet(guardian, new String[]{"Scepter", "Focus"}, getIconFor("scepter_focus")),
                new WeaponSet(guardian, new String[]{"Scepter", "Shield"}, getIconFor("scepter_shield")),
                new WeaponSet(guardian, new String[]{"Scepter", "Torch"}, getIconFor("scepter_torch")),
                new WeaponSet(guardian, new String[]{"Sword", "Focus"}, getIconFor("sword_focus")),
                new WeaponSet(guardian, new String[]{"Sword", "Shield"}, getIconFor("sword_shield")),
                new WeaponSet(guardian, new String[]{"Sword", "Torch"}, getIconFor("sword_torch"))
        );
        guardian.setWeaponSets(guardianWeaponSet);
        professions.add(guardian);

        Profession thief = new Profession("Thief", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/thief.png"), 25, 25));
        List<WeaponSet> thiefWeaponSet = Arrays.asList(
                new WeaponSet(thief, new String[]{"Shortbow"}, getIconFor("shortbow")),
                new WeaponSet(thief, new String[]{"Dagger", "Dagger"}, getIconFor("dagger_dagger")),
                new WeaponSet(thief, new String[]{"Dagger", "Pistol"}, getIconFor("dagger_pistol")),
                new WeaponSet(thief, new String[]{"Pistol", "Dagger"}, getIconFor("pistol_dagger")),
                new WeaponSet(thief, new String[]{"Pistol", "Pistol"}, getIconFor("pistol_pistol")),
                new WeaponSet(thief, new String[]{"Sword", "Dagger"}, getIconFor("sword_dagger")),
                new WeaponSet(thief, new String[]{"Sword", "Pistol"}, getIconFor("sword_pistol"))
        );
        thief.setWeaponSets(thiefWeaponSet);
        professions.add(thief);

        Profession engineer = new Profession("Engineer", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/engineer.png"), 25, 25));
        List<WeaponSet> engineerWeaponSet = Arrays.asList(
                new WeaponSet(engineer, new String[]{"Rifle"}, getIconFor("rifle")),
                new WeaponSet(engineer, new String[]{"Pistol", "Pistol"}, getIconFor("pistol_pistol")),
                new WeaponSet(engineer, new String[]{"Pistol", "Shield"}, getIconFor("pistol_shield"))
        );
        engineer.setWeaponSets(engineerWeaponSet);
        professions.add(engineer);

        Profession mesmer = new Profession("Mesmer", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/mesmer.png"), 25, 25));
        List<WeaponSet> mesmerWeaponSet = Arrays.asList(
                new WeaponSet(mesmer, new String[]{"Greatsword"}, getIconFor("greatsword")),
                new WeaponSet(mesmer, new String[]{"Staff"}, getIconFor("staff")),
                new WeaponSet(mesmer, new String[]{"Scepter", "Pistol"}, getIconFor("scepter_pistol")),
                new WeaponSet(mesmer, new String[]{"Scepter", "Sword"}, getIconFor("scepter_sword")),
                new WeaponSet(mesmer, new String[]{"Scepter", "Focus"}, getIconFor("scepter_focus")),
                new WeaponSet(mesmer, new String[]{"Scepter", "Torch"}, getIconFor("scepter_sword")),
                new WeaponSet(mesmer, new String[]{"Sword", "Pistol"}, getIconFor("sword_pistol")),
                new WeaponSet(mesmer, new String[]{"Sword", "Sword"}, getIconFor("sword_sword")),
                new WeaponSet(mesmer, new String[]{"Sword", "Focus"}, getIconFor("sword_focus")),
                new WeaponSet(mesmer, new String[]{"Sword", "Torch"}, getIconFor("sword_torch"))
        );
        mesmer.setWeaponSets(mesmerWeaponSet);
        professions.add(mesmer);

        Profession revenant = new Profession("Revenant", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/revenant.png"), 25, 25));
        List<WeaponSet> revenantWeaponSet = Arrays.asList(
                new WeaponSet(revenant, new String[]{"Hammer"}, getIconFor("hammer")),
                new WeaponSet(revenant, new String[]{"Staff"}, getIconFor("staff")),
                new WeaponSet(revenant, new String[]{"Mace", "Axe"}, getIconFor("mace_axe")),
                new WeaponSet(revenant, new String[]{"Mace", "Sword"}, getIconFor("mace_sword")),
                new WeaponSet(revenant, new String[]{"Sword", "Axe"}, getIconFor("sword_axe")),
                new WeaponSet(revenant, new String[]{"Sword", "Sword"}, getIconFor("sword_sword"))
        );
        revenant.setWeaponSets(revenantWeaponSet);
        professions.add(revenant);
    }

    public List<Profession> getProfessions() {
        return professions;
    }

    private ImageIcon getIconFor(String key) {
        Map<String, ImageIcon> iconMap = new HashMap<>();
        iconMap.put("axe", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/axe.png"), 25, 25));
        iconMap.put("axe_axe", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/axe_axe.jpg"), 50, 25));
        iconMap.put("axe_dagger", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/axe_dagger.jpg"), 50, 25));
        iconMap.put("axe_focus", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/axe_focus.jpg"), 50, 25));
        iconMap.put("axe_mace", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/axe_mace.jpg"), 50, 25));
        iconMap.put("axe_sword", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/axe_sword.jpg"), 50, 25));
        iconMap.put("axe_torch", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/axe_torch.jpg"), 50, 25));
        iconMap.put("axe_shield", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/axe_shield.jpg"), 50, 25));
        iconMap.put("axe_warhorn", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/axe_warhorn.jpg"), 50, 25));
        iconMap.put("dagger", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/dagger.png"), 25, 25));
        iconMap.put("dagger_dagger", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/dagger_dagger.jpg"), 50, 25));
        iconMap.put("dagger_focus", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/dagger_focus.jpg"), 50, 25));
        iconMap.put("dagger_pistol", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/dagger_pistol.jpg"), 50, 25));
        iconMap.put("dagger_warhorn", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/dagger_warhorn.jpg"), 50, 25));
        iconMap.put("focus", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/focus.png"), 25, 25));
        iconMap.put("greatsword", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/greatsword.png"), 25, 25));
        iconMap.put("hammer", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/hammer.png"), 25, 25));
        iconMap.put("longbow", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/longbow.png"), 25, 25));
        iconMap.put("mace", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/mace.png"), 25, 25));
        iconMap.put("mace_axe", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/mace_axe.jpg"), 50, 25));
        iconMap.put("mace_focus", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/mace_focus.jpg"), 50, 25));
        iconMap.put("mace_mace", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/mace_mace.jpg"), 50, 25));
        iconMap.put("mace_sword", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/mace_sword.jpg"), 50, 25));
        iconMap.put("mace_torch", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/mace_torch.jpg"), 50, 25));
        iconMap.put("mace_shield", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/mace_warhorn.jpg"), 50, 25));
        iconMap.put("mace_warhorn", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/mace_warhorn.jpg"), 50, 25));
        iconMap.put("pistol", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/pistol.png"), 25, 25));
        iconMap.put("pistol_dagger", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/pistol_dagger.jpg"), 50, 25));
        iconMap.put("pistol_pistol", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/pistol_pistol.jpg"), 50, 25));
        iconMap.put("pistol_shield", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/pistol_shield.jpg"), 50, 25));
        iconMap.put("rifle", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/rifle.png"), 25, 25));
        iconMap.put("scepter", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/scepter.png"), 25, 25));
        iconMap.put("scepter_dagger", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/scepter_dagger.jpg"), 50, 25));
        iconMap.put("scepter_focus", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/scepter_focus.jpg"), 50, 25));
        iconMap.put("scepter_pistol", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/scepter_pistol.jpg"), 50, 25));
        iconMap.put("scepter_shield", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/scepter_shield.jpg"), 50, 25));
        iconMap.put("scepter_sword", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/scepter_sword.jpg"), 50, 25));
        iconMap.put("scepter_torch", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/scepter_torch.jpg"), 50, 25));
        iconMap.put("scepter_warhorn", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/scepter_warhorn.jpg"), 50, 25));
        iconMap.put("shield", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/shield.png"), 25, 25));
        iconMap.put("shortbow", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/shortbow.png"), 25, 25));
        iconMap.put("staff", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/staff.png"), 25, 25));
        iconMap.put("sword", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/sword.png"), 25, 25));
        iconMap.put("sword_axe", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/sword_axe.jpg"), 50, 25));
        iconMap.put("sword_dagger", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/sword_dagger.jpg"), 50, 25));
        iconMap.put("sword_focus", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/sword_focus.jpg"), 50, 25));
        iconMap.put("sword_mace", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/sword_mace.jpg"), 50, 25));
        iconMap.put("sword_pistol", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/sword_pistol.jpg"), 50, 25));
        iconMap.put("sword_sword", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/sword_sword.jpg"), 50, 25));
        iconMap.put("sword_shield", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/sword_shield.jpg"), 50, 25));
        iconMap.put("sword_torch", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/sword_torch.jpg"), 50, 25));
        iconMap.put("sword_warhorn", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/sword_warhorn.jpg"), 50, 25));
        iconMap.put("torch", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/torch.png"), 25, 25));
        iconMap.put("warhorn", methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/weapon_icons/warhorn.png"), 25, 25));
        return iconMap.get(key);
    }
}
