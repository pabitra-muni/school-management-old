package org.ahant.core.model;

/**
 * Created by ahant on 7/16/2016.
 */
public class Student extends Person implements Result {
    private Person father;
    private Person mother;
    private Person guardian;
    private String standard;
    private String section;

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getGuardian() {
        return guardian;
    }

    public void setGuardian(Person guardian) {
        this.guardian = guardian;
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
