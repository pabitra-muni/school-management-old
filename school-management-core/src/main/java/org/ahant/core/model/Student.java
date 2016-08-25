package org.ahant.core.model;

import org.ahant.core.annotation.FieldInfo;

/**
 * Created by ahant on 7/16/2016.
 */
public class Student extends Person implements Result {
    private String fatherName;
    private String motherName;
    private String guardianName;
    @FieldInfo(optional = false)
    private String standard;
    @FieldInfo(optional = false)
    private String section;

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
