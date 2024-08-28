package view;

import model.ProfessionGenerator;
import controller.FileManager;
import gui.ListCellRenderer;
import gui.UpdateSkillButtonTask;
import gui.UpdateSpecializationButtonsTask;
import model.Build;
import model.Profession;
import model.Specialization;
import model.WeaponSet;
import util.DialogManagerUtil;
import util.methodsUtil;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Principal extends JFrame {
    private JPanel principalWindow;
    private JButton saveBuildButton;
    private JButton exportBuildButton;
    private JPanel cards;
    private JComboBox<Profession> professionsComboBox;
    private JComboBox<WeaponSet> weaponSetComboBox;
    private JComboBox<Build> savedBuildsComboBox;
    private JToolBar menuToolBar;
    private JButton importBuildButton;
    private final String[] SLOTNAMES = {"Weapon_1", "Weapon_2", "Weapon_3", "Weapon_4", "Weapon_5"};
    private static Profession selectedProfession;
    private static WeaponSet selectedWeaponSet;
    private Specialization selectedSpecialization1;
    private Specialization selectedSpecialization2;
    private Specialization selectedSpecialization3;
    private static final Skills skillWindow = new Skills();
    private String selectedAttunement = "Fire";
    private final ExecutorService service = Executors.newSingleThreadExecutor();
    private boolean buildHasBeenLoaded = false;

    public JPanel getPrincipalWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuToolBar.setFloatable(false);
        CardLayout cardLayout = new CustomCardLayout();
        cards.setLayout(cardLayout);
        cards.add(skillWindow.getSkillsWindow());
        ProfessionGenerator professionGenerator = new ProfessionGenerator();
        professionsComboBox.setModel(new DefaultComboBoxModel<>(professionGenerator.getProfessions().toArray(new Profession[0])));
        professionsComboBox.setRenderer(new ListCellRenderer());
        selectedProfession = professionsComboBox.getItemAt(professionsComboBox.getSelectedIndex());
        weaponSetComboBox.setModel(new DefaultComboBoxModel<>(selectedProfession.getWeaponSets().toArray(new WeaponSet[0])));
        weaponSetComboBox.setRenderer(new ListCellRenderer());
        selectedWeaponSet = selectedProfession.getWeaponSets().get(weaponSetComboBox.getSelectedIndex());
        savedBuildsComboBox.setModel(new DefaultComboBoxModel<>(FileManager.getInstance().readAllBuildFiles().toArray(new Build[0])));
        savedBuildsComboBox.setRenderer(new ListCellRenderer());
        setSpecializationsComboBoxes();
        setButtonsIcons();
        updateSkillButtons();
        return principalWindow;
    }

    public Principal() {

        skillWindow.getButtonsForSkillsSlotsNumber(5).forEach(attunementButton -> attunementButton.addActionListener(e -> {
            switch (attunementButton.getName()) {
                case "fireAttunementButton" -> selectedAttunement = "Fire";
                case "waterAttunementButton" -> selectedAttunement = "Water";
                case "airAttunementButton" -> selectedAttunement = "Air";
                case "earthAttunementButton" -> selectedAttunement = "Earth";
                default -> selectedAttunement = null;
            }
            updateSkillButtons();
        }));

        professionsComboBox.addActionListener(e -> {
            selectedProfession = professionsComboBox.getItemAt(professionsComboBox.getSelectedIndex());
            setSpecializationsComboBoxes();
            weaponSetComboBox.setModel(new DefaultComboBoxModel<>(selectedProfession.getWeaponSets().toArray(new WeaponSet[0])));
            selectedWeaponSet = selectedProfession.getWeaponSets().get(weaponSetComboBox.getSelectedIndex());
            if (selectedProfession.getName().equalsIgnoreCase("Elementalist")) {
                skillWindow.getButtonsForSkillsSlotsNumber(5).forEach(button -> button.setVisible(true));
                selectedAttunement = "Fire";
            } else {
                skillWindow.getButtonsForSkillsSlotsNumber(5).forEach(button -> button.setVisible(false));
                selectedAttunement = null;
            }
            updateSkillButtons();
        });

        weaponSetComboBox.addActionListener(e -> {
            selectedWeaponSet = selectedProfession.getWeaponSets().get(weaponSetComboBox.getSelectedIndex());
            updateSkillButtons();
        });

        savedBuildsComboBox.addActionListener(e -> {
            buildHasBeenLoaded = true;
            Build build = savedBuildsComboBox.getItemAt(savedBuildsComboBox.getSelectedIndex());
            professionsComboBox.setSelectedIndex(build.getProfession());
            weaponSetComboBox.setSelectedIndex(build.getWeaponSet());
            skillWindow.getSpecializationComboBox(0).setSelectedIndex(build.getSpecialization1Index());
            skillWindow.setTraitsButtonGroups(0, build.getS1t1Trait() - 1);
            skillWindow.setTraitsButtonGroups(1, build.getS1t2Trait() - 1);
            skillWindow.setTraitsButtonGroups(2, build.getS1t3Trait() - 1);
            skillWindow.getSpecializationComboBox(1).setSelectedIndex(build.getSpecialization2Index());
            skillWindow.setTraitsButtonGroups(3, build.getS2t1Trait() - 1);
            skillWindow.setTraitsButtonGroups(4, build.getS2t2Trait() - 1);
            skillWindow.setTraitsButtonGroups(5, build.getS2t3Trait() - 1);
            skillWindow.getSpecializationComboBox(2).setSelectedIndex(build.getSpecialization3Index());
            skillWindow.setTraitsButtonGroups(6, build.getS3t1Trait() - 1);
            skillWindow.setTraitsButtonGroups(7, build.getS3t2Trait() - 1);
            skillWindow.setTraitsButtonGroups(8, build.getS3t3Trait() - 1);
            buildHasBeenLoaded = false;
        });

        saveBuildButton.addActionListener(e -> {
            Object[] options = {"Si", "No"};
            int reply = DialogManagerUtil.showOptionDialog(
                    options,
                    "¿Desea guardar esta configuración?",
                    "¡Atención!",
                    JOptionPane.YES_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    1);
            if (reply == JOptionPane.YES_OPTION) {
                String buildName = DialogManagerUtil.showInputDialog("Nombre de la configuración");
                if (buildName.trim().equals("")) {
                    DialogManagerUtil.showErrorDialog("Error. Debes introducir un nombre para la configuración");
                } else {
                    Build build = new Build(buildName, professionsComboBox.getSelectedIndex(), weaponSetComboBox.getSelectedIndex(),
                            skillWindow.getSpecializationComboBox(0).getSelectedIndex(),
                            skillWindow.getTraitsButtonGroupsSelectedOption(0),
                            skillWindow.getTraitsButtonGroupsSelectedOption(1),
                            skillWindow.getTraitsButtonGroupsSelectedOption(2),
                            skillWindow.getSpecializationComboBox(1).getSelectedIndex(),
                            skillWindow.getTraitsButtonGroupsSelectedOption(3),
                            skillWindow.getTraitsButtonGroupsSelectedOption(4),
                            skillWindow.getTraitsButtonGroupsSelectedOption(5),
                            skillWindow.getSpecializationComboBox(2).getSelectedIndex(),
                            skillWindow.getTraitsButtonGroupsSelectedOption(6),
                            skillWindow.getTraitsButtonGroupsSelectedOption(7),
                            skillWindow.getTraitsButtonGroupsSelectedOption(8));
                    try {
                        FileManager.getInstance().writeBuildToFile(build, build.getBuildName());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    DialogManagerUtil.showInfoDialog("Configuración guardada");
                    savedBuildsComboBox.setModel(new DefaultComboBoxModel<>(FileManager.getInstance().readAllBuildFiles().toArray(new Build[0])));
                    savedBuildsComboBox.setRenderer(new ListCellRenderer());
                }
            }
        });

        exportBuildButton.addActionListener(e -> {
            Build build = savedBuildsComboBox.getItemAt(savedBuildsComboBox.getSelectedIndex());
            JFileChooser f = new JFileChooser();
            f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int status = f.showSaveDialog(null);
            if (status != JFileChooser.CANCEL_OPTION) {
                String path;
                try {
                    path = f.getSelectedFile().toString();
                } catch (NullPointerException exception) {
                    path = null;
                }
                if (build != null && path != null) {
                    try {
                        FileManager.getInstance().writeBuildToXml(build, path);
                        DialogManagerUtil.showInfoDialog("Configuración exportada");
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                } else {
                    DialogManagerUtil.showErrorDialog("Error: Selecciona una configuración desde el menú para exportarla y un destino válido");
                }
            }
        });

        importBuildButton.addActionListener(e -> {
            JFileChooser f = new JFileChooser();
            f.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int status = f.showSaveDialog(null);
            if (status != JFileChooser.CANCEL_OPTION) {
                String path;
                try {
                    path = f.getSelectedFile().toString();
                } catch (NullPointerException exception) {
                    path = null;
                }
                if (path != null) {
                    if (FileManager.getInstance().readBuildFromXmlAndWriteToFile(path)) {
                        DialogManagerUtil.showInfoDialog("Configuración importada");
                        savedBuildsComboBox.setModel(new DefaultComboBoxModel<>(FileManager.getInstance().readAllBuildFiles().toArray(new Build[0])));
                        savedBuildsComboBox.setRenderer(new ListCellRenderer());
                    } else {
                        DialogManagerUtil.showErrorDialog("Error: Fichero xml no válido");
                    }
                } else {
                    DialogManagerUtil.showErrorDialog("Error: Directorio no válido");
                }
            }
        });

        skillWindow.getSpecializationComboBox(0).addActionListener(e -> {
            selectedSpecialization1 = skillWindow.getSpecializationComboBox(0).getItemAt(skillWindow.getSpecializationComboBox(0).getSelectedIndex());
            updateSpecializationButtons(selectedSpecialization1, 0);

        });

        skillWindow.getSpecializationComboBox(1).addActionListener(e -> {
            selectedSpecialization2 = skillWindow.getSpecializationComboBox(1).getItemAt(skillWindow.getSpecializationComboBox(1).getSelectedIndex());
            updateSpecializationButtons(selectedSpecialization2, 1);

        });

        skillWindow.getSpecializationComboBox(2).addActionListener(e -> {
            selectedSpecialization3 = skillWindow.getSpecializationComboBox(2).getItemAt(skillWindow.getSpecializationComboBox(2).getSelectedIndex());
            updateSpecializationButtons(selectedSpecialization3, 2);

        });
    }

    private void updateSkillButtons() {
        for (int i = 0; i < SLOTNAMES.length; i++) {
            service.execute(new UpdateSkillButtonTask(
                    skillWindow.getButtonsForSkillsSlotsNumber(i),
                    i,
                    selectedProfession.getName(),
                    selectedAttunement,
                    selectedWeaponSet,
                    selectedWeaponSet.getWeaponTypeSet().length == 2,
                    SLOTNAMES[i]));
        }
    }

    private void updateSpecializationButtons(Specialization specialization, int index) {
        service.execute(new UpdateSpecializationButtonsTask(
                skillWindow.getButtonsForSpecializationNumber(index),
                selectedProfession.getName(),
                specialization.getName()));
    }

    private void setSpecializationsComboBoxes() {
        skillWindow.getSpecializationComboBox(0).setModel(new DefaultComboBoxModel<>(FileManager.getInstance().getSpecializationsForProfession(selectedProfession.getName()).toArray(new Specialization[0])));
        skillWindow.getSpecializationComboBox(0).setRenderer(new ListCellRenderer());
        skillWindow.getSpecializationComboBox(1).setModel(new DefaultComboBoxModel<>(FileManager.getInstance().getSpecializationsForProfession(selectedProfession.getName()).toArray(new Specialization[0])));
        skillWindow.getSpecializationComboBox(1).setRenderer(new ListCellRenderer());
        skillWindow.getSpecializationComboBox(2).setModel(new DefaultComboBoxModel<>(FileManager.getInstance().getSpecializationsForProfession(selectedProfession.getName()).toArray(new Specialization[0])));
        skillWindow.getSpecializationComboBox(2).setRenderer(new ListCellRenderer());
        if (!buildHasBeenLoaded) {
            skillWindow.getSpecializationComboBox(0).setSelectedIndex(0);
            skillWindow.getSpecializationComboBox(1).setSelectedIndex(1);
            skillWindow.getSpecializationComboBox(2).setSelectedIndex(2);
        }
    }

    private void setButtonsIcons() {
        ImageIcon newIcon = methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/save.png"), 50, 50);
        saveBuildButton.setIcon(newIcon);
        saveBuildButton.setOpaque(false);
        saveBuildButton.setContentAreaFilled(false);
        saveBuildButton.setBorderPainted(false);
        saveBuildButton.setFocusPainted(false);

        newIcon = methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/export.png"), 50, 50);
        exportBuildButton.setIcon(newIcon);
        exportBuildButton.setOpaque(false);
        exportBuildButton.setContentAreaFilled(false);
        exportBuildButton.setBorderPainted(false);
        exportBuildButton.setFocusPainted(false);

        newIcon = methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/import.png"), 50, 50);
        importBuildButton.setIcon(newIcon);
        importBuildButton.setOpaque(false);
        importBuildButton.setContentAreaFilled(false);
        importBuildButton.setBorderPainted(false);
        importBuildButton.setFocusPainted(false);
    }

    public static class CustomCardLayout extends CardLayout {
        @Override
        public Dimension preferredLayoutSize(Container parent) {
            Component current = findCurrentComponent(parent);
            if (current != null) {
                Insets insets = parent.getInsets();
                Dimension pref = current.getPreferredSize();
                pref.width += insets.left + insets.right;
                pref.height += insets.top + insets.bottom;
                return pref;
            }
            return super.preferredLayoutSize(parent);
        }

        public Component findCurrentComponent(Container parent) {
            for (Component comp : parent.getComponents()) {
                if (comp.isVisible()) {
                    return comp;
                }
            }
            return null;
        }
    }
}