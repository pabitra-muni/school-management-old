package org.ahant.core.model;

/**
 * Created by ahant on 7/16/2016.
 */
public enum Gender {
    MALE("Male"), FEMALE("Female");

    String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
