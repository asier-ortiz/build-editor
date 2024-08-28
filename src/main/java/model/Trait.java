package model;

import java.io.Serializable;
import java.util.List;

public class Trait implements Serializable {
    public int id;
    public int tier;
    public int order;
    public String name;
    public String description;
    public String slot;
    public List<TraitFact> facts;
    public int specialization;
    public String icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
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

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public List<TraitFact> getFacts() {
        return facts;
    }

    public void setFacts(List<TraitFact> facts) {
        this.facts = facts;
    }

    public int getSpecialization() {
        return specialization;
    }

    public void setSpecialization(int specialization) {
        this.specialization = specialization;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Trait{" +
                "id=" + id +
                ", tier=" + tier +
                ", order=" + order +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", slot='" + slot + '\'' +
                ", facts=" + facts +
                ", specialization=" + specialization +
                ", icon='" + icon + '\'' +
                '}';
    }
}