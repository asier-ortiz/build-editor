package model;

import java.io.Serializable;

public class Fact implements Serializable {
    public String text;
    public String type;
    public String icon;
    public String value;
    public Number hit_count;
    public Number dmg_multiplier;
    public Number duration;
    public String status;
    public String description;
    public int apply_count;
    public int distance;
    public String field_type;

    @Override
    public String toString() {
        return "SkillFact{" +
                "text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", icon='" + icon + '\'' +
                ", value='" + value + '\'' +
                ", hit_count=" + hit_count +
                ", dmg_multiplier=" + dmg_multiplier +
                ", duration=" + duration +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", apply_count=" + apply_count +
                ", distance=" + distance +
                ", field_type='" + field_type + '\'' +
                '}';
    }
}