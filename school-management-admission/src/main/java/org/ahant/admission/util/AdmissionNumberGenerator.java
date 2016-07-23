package org.ahant.admission.util;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.ahant.core.exception.ApplicationException;
import org.ahant.core.model.School;
import org.ahant.core.util.NumberGenerator;

import static org.ahant.core.util.CommonUtil.resizeTo;

/**
 * Created by ahant on 7/18/2016.
 */
public class AdmissionNumberGenerator implements NumberGenerator {
    private School school;

    @Override
    public synchronized String generateNumber() {
        String generatedNumber;
        try {
            Thread.sleep(1);
            StringBuilder admissionNumber = new StringBuilder();
            String schoolCode = resizeTo(getSchoolCode(), 4, '0');
            admissionNumber.append(System.currentTimeMillis());
            admissionNumber.append(schoolCode);
            generatedNumber = admissionNumber.toString();
        } catch (InterruptedException e) {
            throw new ApplicationException(e.getMessage());
        }
        return generatedNumber;
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
