package model;

import java.io.Serializable;
import java.util.List;

public class Skill implements Serializable, Comparable<Skill> {
    public int id;
    public String name;
    public String description;
    public String icon;
    public String type;
    public String weapon_type;
    public String slot;
    public String attunement;
    public List<String> professions;
    public List<Fact> facts;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeapon_type() {
        return weapon_type;
    }

    public void setWeapon_type(String weapon_type) {
        this.weapon_type = weapon_type;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getAttunement() {
        return attunement;
    }

    public void setAttunement(String attunement) {
        this.attunement = attunement;
    }

    public List<String> getProfessions() {
        return professions;
    }

    public void setProfessions(List<String> professions) {
        this.professions = professions;
    }

    public List<Fact> getSkillFacts() {
        return facts;
    }

    public void setSkillFacts(List<Fact> facts) {
        this.facts = facts;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", type='" + type + '\'' +
                ", weapon_type='" + weapon_type + '\'' +
                ", slot='" + slot + '\'' +
                ", attunement='" + attunement + '\'' +
                ", professions=" + professions +
                ", skillFacts=" + facts +
                '}';
    }

    @Override
    public int compareTo(Skill s) {
        return this.getSlot().compareTo(s.getSlot());
    }
}
