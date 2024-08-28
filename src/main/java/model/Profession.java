package model;

import javax.swing.*;
import java.util.List;

public class Profession {

    private final String name;
    private final ImageIcon icon;
    private List<WeaponSet> weaponSets;

    public Profession(String name, ImageIcon icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public List<WeaponSet> getWeaponSets() {
        return weaponSets;
    }

    public void setWeaponSets(List<WeaponSet> weaponSets) {
        this.weaponSets = weaponSets;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "name='" + name + '\'' +
                ", icon=" + icon +
                ", weaponSets=" + weaponSets +
                '}';
    }
}
