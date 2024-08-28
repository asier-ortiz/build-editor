package model;

import javax.swing.*;
import java.util.Arrays;

public class WeaponSet {

    private final Profession profession;
    private final String[] weaponTypeSet;
    private final ImageIcon weaponIcon;


    public WeaponSet(Profession profession, String[] weaponTypeSet, ImageIcon weaponIcon) {
        this.profession = profession;
        this.weaponTypeSet = weaponTypeSet;
        this.weaponIcon = weaponIcon;
    }

    public Profession getProfession() {
        return profession;
    }

    public String[] getWeaponTypeSet() {
        return weaponTypeSet;
    }

    public ImageIcon getWeaponIcon() {
        return weaponIcon;
    }

    public String getWeaponsTypeSetToString() {
        StringBuilder st = new StringBuilder();
        Arrays.stream(getWeaponTypeSet()).forEach(weapon -> st.append(weapon).append(" "));
        return st.toString();
    }
}