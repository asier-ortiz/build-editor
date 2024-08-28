package gui;

import model.Build;
import model.Profession;
import model.Specialization;
import model.WeaponSet;

import javax.swing.*;
import java.awt.*;

public class ListCellRenderer extends DefaultListCellRenderer {

    private final Color background = new Color(0, 100, 255, 15);
    private final Color defaultBackground = (Color) UIManager.get("List.background");

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        switch (value.getClass().toString()) {
            case "class model.Profession":
                Profession profession = (Profession) value;
                this.setText(profession.getName());
                this.setIcon(profession.getIcon());
                if (!isSelected) {
                    this.setBackground(index % 2 == 0 ? background : defaultBackground);
                }
                return this;

            case "class model.WeaponSet":
                WeaponSet weaponSet = (WeaponSet) value;
                this.setText(weaponSet.getWeaponsTypeSetToString());
                this.setIcon(weaponSet.getWeaponIcon());
                if (!isSelected) {
                    this.setBackground(index % 2 == 0 ? background : defaultBackground);
                }
                return this;

            case "class model.Specialization":
                Specialization specialization = (Specialization) value;
                this.setText(specialization.getName());
                // this.setIcon(methodsUtil.resizeImageIcon(methodsUtil.getIconFromUrl(specialization.getIcon()), 20, 20));
                if (!isSelected) {
                    this.setBackground(index % 2 == 0 ? background : defaultBackground);
                }
                return this;

            case "class model.Build":
                Build build = (Build) value;
                this.setText(build.getBuildName());
                if (!isSelected) {
                    this.setBackground(index % 2 == 0 ? background : defaultBackground);
                }
                return this;

            default:
                return this;

        }
    }
}