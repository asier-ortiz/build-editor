package model;

import java.io.Serializable;
import java.util.List;

public class Specialization implements Serializable {
    public int id;
    public String name;
    public String profession;
    public boolean elite;
    public List<Number> minor_traits;
    public List<Number> major_traits;
    public String icon;
    public String background;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public boolean isElite() {
        return elite;
    }

    public void setElite(boolean elite) {
        this.elite = elite;
    }

    public List<Number> getMinor_traits() {
        return minor_traits;
    }

    public void setMinor_traits(List<Number> minor_traits) {
        this.minor_traits = minor_traits;
    }

    public List<Number> getMajor_traits() {
        return major_traits;
    }

    public void setMajor_traits(List<Number> major_traits) {
        this.major_traits = major_traits;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", elite=" + elite +
                ", minor_traits=" + minor_traits +
                ", major_traits=" + major_traits +
                ", icon='" + icon + '\'' +
                ", background='" + background + '\'' +
                '}';
    }
}
