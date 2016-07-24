package org.ahant.auth.model;

/**
 * Created by ahant on 7/24/2016.
 */
public enum Role {
    ADMIN("admin"),
    TEACHER("teacher"),
    PARENT("parent"),
    GUARDIAN("guardian"),
    STUDENT("student");

    private String value;

    Role(String role) {
        this.value = role;
    }

    public String getValue() {
        return value;
    }
}
