package org.ahant.admission.util;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.ahant.core.model.School;

/**
 * Created by ahant on 7/18/2016.
 */
public class AdmissionNumberGenerator implements NumberGenerator{
    private School school;

    public synchronized String generateNumber() throws Exception {
        Thread.sleep(1);
        StringBuilder admissionNumber = new StringBuilder();
        String schoolCode = resizeTo(getSchoolCode(), 4, '0');
        admissionNumber.append(schoolCode);
        admissionNumber.append(System.currentTimeMillis());
        return admissionNumber.toString();
    }

    private String resizeTo(String str, int resizeLength, Character resizeChar) {
        String temp = str;
        if (temp.length() > resizeLength) {
            temp = temp.substring(0, resizeLength);
        } else if (temp.length() < resizeLength) {
            temp += getCharacters(resizeLength - temp.length(), resizeChar);
        }
        return temp;
    }

    private String getCharacters(int count, Character val) {
        StringBuilder temp = new StringBuilder();
        while (count > 0) {
            temp.append(val);
            count++;
        }
        return temp.toString();
    }

    private String getSchoolCode() {
        String temp = null;
        if (!Strings.isNullOrEmpty(school.getCode())) {
            temp = school.getCode();
        }
        if (temp == null) {
            Preconditions.checkArgument(!Strings.isNullOrEmpty(school.getName()), "Either school name or code is required.");
            temp = school.getName();
        }
        return temp;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
