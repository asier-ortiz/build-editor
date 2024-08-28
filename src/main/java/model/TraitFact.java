package model;

import java.io.Serializable;

public class TraitFact implements Serializable {
    public String text;
    public String type;
    public String icon;
    public Number value;
    public String target;
    public Number duration;
    public String status;
    public String description;
    public Number apply_count;

    @Override
    public String toString() {
        return "TraitFact{" +
                "text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", icon='" + icon + '\'' +
                ", value=" + value +
                ", target='" + target + '\'' +
                ", duration=" + duration +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", apply_count=" + apply_count +
                '}';
    }
}
