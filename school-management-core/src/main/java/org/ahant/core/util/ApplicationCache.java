package org.ahant.core.util;

import org.ahant.core.model.School;

/**
 * Created by ahant on 8/2/2016.
 */
public class ApplicationCache {
    private static School currentSchool;

    private ApplicationCache() {
    }

    public static School getCurrentSchool() {
        return currentSchool;
    }

    public static void setCurrentSchool(School school) {
        currentSchool = school;
    }
}
