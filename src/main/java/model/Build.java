package model;

import java.io.Serializable;

public class Build implements Serializable {
    private static final long serialVersionUID = 6928408512887702260L;
    private String buildName;
    private final int profession;
    private final int weaponSet;
    private final int specialization1Index;
    private final int s1t1Trait;
    private final int s1t2Trait;
    private final int s1t3Trait;
    private final int specialization2Index;
    private final int s2t1Trait;
    private final int s2t2Trait;
    private final int s2t3Trait;
    private final int specialization3Index;
    private final int s3t1Trait;
    private final int s3t2Trait;
    private final int s3t3Trait;

    public Build(String buildName, int profession, int weaponSet, int specialization1Index, int s1t1Trait, int s1t2Trait,
                 int s1t3Trait, int specialization2Index, int s2t1Trait, int s2t2Trait, int s2t3Trait, int specialization3Index,
                 int s3t1Trait, int s3t2Trait, int s3t3Trait) {
        this.buildName = buildName;
        this.profession = profession;
        this.weaponSet = weaponSet;
        this.specialization1Index = specialization1Index;
        this.s1t1Trait = s1t1Trait;
        this.s1t2Trait = s1t2Trait;
        this.s1t3Trait = s1t3Trait;
        this.specialization2Index = specialization2Index;
        this.s2t1Trait = s2t1Trait;
        this.s2t2Trait = s2t2Trait;
        this.s2t3Trait = s2t3Trait;
        this.specialization3Index = specialization3Index;
        this.s3t1Trait = s3t1Trait;
        this.s3t2Trait = s3t2Trait;
        this.s3t3Trait = s3t3Trait;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public int getProfession() {
        return profession;
    }

    public int getWeaponSet() {
        return weaponSet;
    }

    public int getSpecialization1Index() {
        return specialization1Index;
    }

    public int getS1t1Trait() {
        return s1t1Trait;
    }

    public int getS1t2Trait() {
        return s1t2Trait;
    }

    public int getS1t3Trait() {
        return s1t3Trait;
    }

    public int getSpecialization2Index() {
        return specialization2Index;
    }

    public int getS2t1Trait() {
        return s2t1Trait;
    }

    public int getS2t2Trait() {
        return s2t2Trait;
    }

    public int getS2t3Trait() {
        return s2t3Trait;
    }

    public int getSpecialization3Index() {
        return specialization3Index;
    }

    public int getS3t1Trait() {
        return s3t1Trait;
    }

    public int getS3t2Trait() {
        return s3t2Trait;
    }

    public int getS3t3Trait() {
        return s3t3Trait;
    }

    @Override
    public String toString() {
        return "Build{" +
                "buildName='" + buildName + '\'' +
                ", profession=" + profession +
                ", weaponSet=" + weaponSet +
                ", specialization1Index=" + specialization1Index +
                ", s1t1Trait=" + s1t1Trait +
                ", s1t2Trait=" + s1t2Trait +
                ", s1t3Trait=" + s1t3Trait +
                ", specialization2Index=" + specialization2Index +
                ", s2t1Trait=" + s2t1Trait +
                ", s2t2Trait=" + s2t2Trait +
                ", s2t3Trait=" + s2t3Trait +
                ", specialization3Index=" + specialization3Index +
                ", s3t1Trait=" + s3t1Trait +
                ", s3t2Trait=" + s3t2Trait +
                ", s3t3Trait=" + s3t3Trait +
                '}';
    }
}