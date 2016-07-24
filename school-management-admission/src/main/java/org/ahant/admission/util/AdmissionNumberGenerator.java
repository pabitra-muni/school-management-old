package org.ahant.admission.util;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.ahant.core.model.School;
import org.ahant.core.util.CommonUtil;
import org.ahant.core.util.NumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import static org.ahant.core.util.CommonUtil.resizeTo;

/**
 * Created by ahant on 7/18/2016.
 */
public class AdmissionNumberGenerator implements NumberGenerator {
    private School school;
    @Autowired
    Environment env;
    private static AtomicLong current = new AtomicLong(System.currentTimeMillis());

    @Override
    public String generateNumber() {
        String generatedNumber;
        StringBuilder admissionNumber = new StringBuilder();
        String schoolCode = resizeTo(getSchoolCode(), getSchoolCodeLengh(), getSchoolCodeSuffix());
        admissionNumber.append(schoolCode);
        admissionNumber.append(getUniqueNumber());
        generatedNumber = admissionNumber.toString();
        return generatedNumber;
    }

    private Long getUniqueNumber() {
        updateCurrentDate();
        return current.incrementAndGet();
    }

    private synchronized void updateCurrentDate() {
        if(CommonUtil.isNotToday(new Date(current.get()))){
            current.set(System.currentTimeMillis());
        }
    }

    private int getSchoolCodeLengh() {
        return Integer.valueOf(env.getProperty("school.code.length"));
    }

    private String getSchoolCodeSuffix() {
        return env.getProperty("school.code.suffix");
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
