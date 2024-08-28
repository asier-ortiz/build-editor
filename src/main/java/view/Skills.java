package view;

import model.Specialization;
import util.methodsUtil;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Skills extends JFrame {
    /*SKILLS*/
    private JPanel skillsWindow;
    private JButton weaponSkillButton11;
    private JButton weaponSkillButton12;
    private JButton weaponSkillButton13;
    private JButton weaponSkillButton14;
    private JButton weaponSkillButton15;
    private JButton weaponSkillButton21;
    private JButton weaponSkillButton22;
    private JButton weaponSkillButton23;
    private JButton weaponSkillButton24;
    private JButton weaponSkillButton25;
    private JButton weaponSkillButton31;
    private JButton weaponSkillButton32;
    private JButton weaponSkillButton33;
    private JButton weaponSkillButton34;
    private JButton weaponSkillButton35;
    private JButton weaponSkillButton41;
    private JButton weaponSkillButton42;
    private JButton weaponSkillButton43;
    private JButton weaponSkillButton44;
    private JButton weaponSkillButton45;
    private JButton weaponSkillButton51;
    private JButton weaponSkillButton52;
    private JButton weaponSkillButton53;
    private JButton weaponSkillButton54;
    private JButton weaponSkillButton55;
    private JButton fireAttunementButton;
    private JButton waterAttunementButton;
    private JButton airAttunementButton;
    private JButton earthAttunementButton;
    /*SPECIALIZATION 1 */
    private JButton s1t1Minor;
    private JButton s1t1Major1Icon;
    private JButton s1t1Major2Icon;
    private JButton s1t1Major3Icon;
    private JRadioButton s1t1Major1Radio;
    private JRadioButton s1t1Major2Radio;
    private JRadioButton s1t1Major3Radio;
    ButtonGroup s1t1Gp = new ButtonGroup();
    private JButton s1t2Minor;
    private JButton s1t2Major1Icon;
    private JButton s1t2Major2Icon;
    private JButton s1t2Major3Icon;
    private JRadioButton s1t2Major1Radio;
    private JRadioButton s1t2Major2Radio;
    private JRadioButton s1t2Major3Radio;
    ButtonGroup s1t2Gp = new ButtonGroup();
    private JButton s1t3Minor;
    private JButton s1t3Major1Icon;
    private JButton s1t3Major2Icon;
    private JButton s1t3Major3Icon;
    private JRadioButton s1t3Major1Radio;
    private JRadioButton s1t3Major2Radio;
    private JRadioButton s1t3Major3Radio;
    ButtonGroup s1t3Gp = new ButtonGroup();
    /*SPECIALIZATION 2*/
    private JButton s2t1Minor;
    private JButton s2t1Major1Icon;
    private JButton s2t1Major2Icon;
    private JButton s2t1Major3Icon;
    private JRadioButton s2t1Major1Radio;
    private JRadioButton s2t1Major2Radio;
    private JRadioButton s2t1Major3Radio;
    ButtonGroup s2t1Gp = new ButtonGroup();
    private JButton s2t2Minor;
    private JButton s2t2Major1Icon;
    private JButton s2t2Major2Icon;
    private JButton s2t2Major3Icon;
    private JRadioButton s2t2Major1Radio;
    private JRadioButton s2t2Major2Radio;
    private JRadioButton s2t2Major3Radio;
    ButtonGroup s2t2Gp = new ButtonGroup();
    private JButton s2t3Minor;
    private JButton s2t3Major1Icon;
    private JButton s2t3Major2Icon;
    private JButton s2t3Major3Icon;
    private JRadioButton s2t3Major1Radio;
    private JRadioButton s2t3Major2Radio;
    private JRadioButton s2t3Major3Radio;
    ButtonGroup s2t3Gp = new ButtonGroup();
    /*SPECIALIZATION 3*/
    private JButton s3t1Minor;
    private JButton s3t1Major1Icon;
    private JButton s3t1Major2Icon;
    private JButton s3t1Major3Icon;
    private JRadioButton s3t1Major1Radio;
    private JRadioButton s3t1Major2Radio;
    private JRadioButton s3t1Major3Radio;
    ButtonGroup s3t1Gp = new ButtonGroup();
    private JButton s3t2Minor;
    private JButton s3t2Major1Icon;
    private JButton s3t2Major2Icon;
    private JButton s3t2Major3Icon;
    private JRadioButton s3t2Major1Radio;
    private JRadioButton s3t2Major2Radio;
    private JRadioButton s3t2Major3Radio;
    ButtonGroup s3t2Gp = new ButtonGroup();
    private JButton s3t3Minor;
    private JButton s3t3Major1Icon;
    private JButton s3t3Major2Icon;
    private JButton s3t3Major3Icon;
    private JRadioButton s3t3Major1Radio;
    private JRadioButton s3t3Major2Radio;
    private JRadioButton s3t3Major3Radio;
    ButtonGroup s3t3Gp = new ButtonGroup();
    /*COMBOBOXES*/
    private JComboBox<Specialization> specialization1ComboBox;
    private JComboBox<Specialization> specialization2ComboBox;
    private JComboBox<Specialization> specialization3ComboBox;

    private final Border emptyBorder = BorderFactory.createEmptyBorder();

    public JPanel getSkillsWindow() {
        setButtonsIcons();
        setButtonsOptions();
        return skillsWindow;
    }

    private void setButtonsIcons() {
        for (int i = 0; i <= 5; i++) {
            getButtonsForSkillsSlotsNumber(i).forEach(button -> {
                button.setIcon(new ImageIcon("./src/resources/empty_skill.png"));
                button.setBorder(emptyBorder);
                button.setBorderPainted(false);
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                button.setOpaque(false);
                button.setBackground(Color.BLACK);
                button.setForeground(Color.BLACK);
            });
        }
        for (int i = 0; i <= 3; i++) {
            getButtonsForSpecializationNumber(i).forEach(button -> {
                button.setIcon(methodsUtil.resizeImageIcon(new ImageIcon("./src/resources/empty_skill.png"), 75, 75));
                button.setBorder(emptyBorder);
                button.setBorderPainted(false);
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                button.setOpaque(false);
                button.setBackground(Color.BLACK);
                button.setForeground(Color.BLACK);
            });
        }
        fireAttunementButton.setIcon(new ImageIcon("./src/resources/fire_attunement.png"));
        fireAttunementButton.setName("fireAttunementButton");
        waterAttunementButton.setIcon(new ImageIcon("./src/resources/water_attunement.png"));
        waterAttunementButton.setName("waterAttunementButton");
        airAttunementButton.setIcon(new ImageIcon("./src/resources/air_attunement.png"));
        airAttunementButton.setName("airAttunementButton");
        earthAttunementButton.setIcon(new ImageIcon("./src/resources/earth_attunement.png"));
        earthAttunementButton.setName("earthAttunementButton");
    }

    private void setButtonsOptions() {
        /*SKILLS*/
        weaponSkillButton12.setVisible(false);
        weaponSkillButton13.setVisible(false);
        weaponSkillButton14.setVisible(false);
        weaponSkillButton15.setVisible(false);
        weaponSkillButton22.setVisible(false);
        weaponSkillButton23.setVisible(false);
        weaponSkillButton24.setVisible(false);
        weaponSkillButton25.setVisible(false);
        weaponSkillButton32.setVisible(false);
        weaponSkillButton33.setVisible(false);
        weaponSkillButton34.setVisible(false);
        weaponSkillButton35.setVisible(false);
        weaponSkillButton42.setVisible(false);
        weaponSkillButton43.setVisible(false);
        weaponSkillButton44.setVisible(false);
        weaponSkillButton45.setVisible(false);
        weaponSkillButton52.setVisible(false);
        weaponSkillButton53.setVisible(false);
        weaponSkillButton54.setVisible(false);
        weaponSkillButton55.setVisible(false);
        /*SPECIALIZATION 1*/
        s1t1Gp.add(s1t1Major1Radio);
        s1t1Gp.add(s1t1Major2Radio);
        s1t1Gp.add(s1t1Major3Radio);
        s1t2Gp.add(s1t2Major1Radio);
        s1t2Gp.add(s1t2Major2Radio);
        s1t2Gp.add(s1t2Major3Radio);
        s1t3Gp.add(s1t3Major1Radio);
        s1t3Gp.add(s1t3Major2Radio);
        s1t3Gp.add(s1t3Major3Radio);
        s1t1Major1Radio.setSelected(true);
        s1t2Major1Radio.setSelected(true);
        s1t3Major1Radio.setSelected(true);
        /*SPECIALIZATION 2*/
        s2t1Gp.add(s2t1Major1Radio);
        s2t1Gp.add(s2t1Major2Radio);
        s2t1Gp.add(s2t1Major3Radio);
        s2t2Gp.add(s2t2Major1Radio);
        s2t2Gp.add(s2t2Major2Radio);
        s2t2Gp.add(s2t2Major3Radio);
        s2t3Gp.add(s2t3Major1Radio);
        s2t3Gp.add(s2t3Major2Radio);
        s2t3Gp.add(s2t3Major3Radio);
        s2t1Major1Radio.setSelected(true);
        s2t2Major1Radio.setSelected(true);
        s2t3Major1Radio.setSelected(true);
        /*SPECIALIZATION 3*/
        s3t1Gp.add(s3t1Major1Radio);
        s3t1Gp.add(s3t1Major2Radio);
        s3t1Gp.add(s3t1Major3Radio);
        s3t2Gp.add(s3t2Major1Radio);
        s3t2Gp.add(s3t2Major2Radio);
        s3t2Gp.add(s3t2Major3Radio);
        s3t3Gp.add(s3t3Major1Radio);
        s3t3Gp.add(s3t3Major2Radio);
        s3t3Gp.add(s3t3Major3Radio);
        s3t1Major1Radio.setSelected(true);
        s3t2Major1Radio.setSelected(true);
        s3t3Major1Radio.setSelected(true);
    }

    public List<JButton> getButtonsForSkillsSlotsNumber(int slotNumber) {
        return switch (slotNumber) {
            case 0 -> List.of(weaponSkillButton11, weaponSkillButton12, weaponSkillButton13, weaponSkillButton14, weaponSkillButton15);
            case 1 -> List.of(weaponSkillButton21, weaponSkillButton22, weaponSkillButton23, weaponSkillButton24, weaponSkillButton25);
            case 2 -> List.of(weaponSkillButton31, weaponSkillButton32, weaponSkillButton33, weaponSkillButton34, weaponSkillButton35);
            case 3 -> List.of(weaponSkillButton41, weaponSkillButton42, weaponSkillButton43, weaponSkillButton44, weaponSkillButton45);
            case 4 -> List.of(weaponSkillButton51, weaponSkillButton52, weaponSkillButton53, weaponSkillButton54, weaponSkillButton55);
            case 5 -> List.of(fireAttunementButton, waterAttunementButton, airAttunementButton, earthAttunementButton);
            default -> new ArrayList<>();
        };
    }

    public List<JButton> getButtonsForSpecializationNumber(int specializationNumber) {
        return switch (specializationNumber) {
            case 0 -> List.of(
                    s1t1Minor, s1t1Major1Icon, s1t1Major2Icon, s1t1Major3Icon,
                    s1t2Minor, s1t2Major1Icon, s1t2Major2Icon, s1t2Major3Icon,
                    s1t3Minor, s1t3Major1Icon, s1t3Major2Icon, s1t3Major3Icon
            );
            case 1 -> List.of(
                    s2t1Minor, s2t1Major1Icon, s2t1Major2Icon, s2t1Major3Icon,
                    s2t2Minor, s2t2Major1Icon, s2t2Major2Icon, s2t2Major3Icon,
                    s2t3Minor, s2t3Major1Icon, s2t3Major2Icon, s2t3Major3Icon
            );
            case 2 -> List.of(
                    s3t1Minor, s3t1Major1Icon, s3t1Major2Icon, s3t1Major3Icon,
                    s3t2Minor, s3t2Major1Icon, s3t2Major2Icon, s3t2Major3Icon,
                    s3t3Minor, s3t3Major1Icon, s3t3Major2Icon, s3t3Major3Icon
            );
            default -> new ArrayList<>();
        };
    }

    public JComboBox<Specialization> getSpecializationComboBox(int comboBoxNumer) {
        return switch (comboBoxNumer) {
            case 0 -> specialization1ComboBox;
            case 1 -> specialization2ComboBox;
            case 2 -> specialization3ComboBox;
            default -> new JComboBox<>();

        };
    }

    public int getTraitsButtonGroupsSelectedOption(int groupIndex) {
        switch (groupIndex) {
            case 0 -> {
                if (s1t1Major1Radio.isSelected()) {
                    return 1;
                } else if (s1t1Major2Radio.isSelected()) {
                    return 2;
                } else {
                    return 3;
                }
            }
            case 1 -> {
                if (s1t2Major1Radio.isSelected()) {
                    return 1;
                } else if (s1t2Major2Radio.isSelected()) {
                    return 2;
                } else {
                    return 3;
                }
            }
            case 2 -> {
                if (s1t3Major1Radio.isSelected()) {
                    return 1;
                } else if (s1t3Major2Radio.isSelected()) {
                    return 2;
                } else {
                    return 3;
                }
            }
            case 3 -> {
                if (s2t1Major1Radio.isSelected()) {
                    return 1;
                } else if (s2t1Major2Radio.isSelected()) {
                    return 2;
                } else {
                    return 3;
                }
            }
            case 4 -> {
                if (s2t2Major1Radio.isSelected()) {
                    return 1;
                } else if (s2t2Major2Radio.isSelected()) {
                    return 2;
                } else {
                    return 3;
                }
            }
            case 5 -> {
                if (s2t3Major1Radio.isSelected()) {
                    return 1;
                } else if (s2t3Major2Radio.isSelected()) {
                    return 2;
                } else {
                    return 3;
                }
            }
            case 6 -> {
                if (s3t1Major1Radio.isSelected()) {
                    return 1;
                } else if (s3t1Major2Radio.isSelected()) {
                    return 2;
                } else {
                    return 3;
                }
            }
            case 7 -> {
                if (s3t2Major1Radio.isSelected()) {
                    return 1;
                } else if (s3t2Major2Radio.isSelected()) {
                    return 2;
                } else {
                    return 3;
                }
            }
            case 8 -> {
                if (s3t3Major1Radio.isSelected()) {
                    return 1;
                } else if (s3t3Major2Radio.isSelected()) {
                    return 2;
                } else {
                    return 3;
                }
            }
        }
        return -1;
    }

    public void setTraitsButtonGroups(int groupIndex, int buttonIndex) {
        switch (groupIndex) {
            case 0 -> {
                switch (buttonIndex) {
                    case 0 -> s1t1Major1Radio.setSelected(true);
                    case 1 -> s1t1Major2Radio.setSelected(true);
                    case 2 -> s1t1Major3Radio.setSelected(true);
                }
            }
            case 1 -> {
                switch (buttonIndex) {
                    case 0 -> s1t2Major1Radio.setSelected(true);
                    case 1 -> s1t2Major2Radio.setSelected(true);
                    case 2 -> s1t2Major3Radio.setSelected(true);
                }
            }
            case 2 -> {
                switch (buttonIndex) {
                    case 0 -> s1t3Major1Radio.setSelected(true);
                    case 1 -> s1t3Major2Radio.setSelected(true);
                    case 2 -> s1t3Major3Radio.setSelected(true);
                }
            }
            case 3 -> {
                switch (buttonIndex) {
                    case 0 -> s2t1Major1Radio.setSelected(true);
                    case 1 -> s2t1Major2Radio.setSelected(true);
                    case 2 -> s2t1Major3Radio.setSelected(true);
                }
            }
            case 4 -> {
                switch (buttonIndex) {
                    case 0 -> s2t2Major1Radio.setSelected(true);
                    case 1 -> s2t2Major2Radio.setSelected(true);
                    case 2 -> s2t2Major3Radio.setSelected(true);
                }
            }
            case 5 -> {
                switch (buttonIndex) {
                    case 0 -> s2t3Major1Radio.setSelected(true);
                    case 1 -> s2t3Major2Radio.setSelected(true);
                    case 2 -> s2t3Major3Radio.setSelected(true);
                }
            }
            case 6 -> {
                switch (buttonIndex) {
                    case 0 -> s3t1Major1Radio.setSelected(true);
                    case 1 -> s3t1Major2Radio.setSelected(true);
                    case 2 -> s3t1Major3Radio.setSelected(true);
                }
            }
            case 7 -> {
                switch (buttonIndex) {
                    case 0 -> s3t2Major1Radio.setSelected(true);
                    case 1 -> s3t2Major2Radio.setSelected(true);
                    case 2 -> s3t2Major3Radio.setSelected(true);
                }
            }
            case 8 -> {
                switch (buttonIndex) {
                    case 0 -> s3t3Major1Radio.setSelected(true);
                    case 1 -> s3t3Major2Radio.setSelected(true);
                    case 2 -> s3t3Major3Radio.setSelected(true);
                }
            }
        }
    }
}