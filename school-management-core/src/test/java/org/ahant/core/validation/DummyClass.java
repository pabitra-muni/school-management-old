package org.ahant.core.validation;

import org.ahant.core.annotation.CollectionType;
import org.ahant.core.annotation.FieldInfo;
import org.ahant.core.model.Gender;

import java.util.Date;
import java.util.List;

import static org.ahant.core.validation.FieldValidatorType.PHONE;
import static org.ahant.core.validation.FieldValidatorType.STRING;

/**
 * Created by ahant on 8/22/2016.
 */
public class DummyClass {
    @FieldInfo(validatorType = STRING)
    private String fullName;
    private Date birthDate;
    private Gender gender;
    @FieldInfo(name = "contactNumber", validatorType = PHONE)
    @CollectionType
    private List<String> contactNumberList;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return new Date(birthDate.getTime());
    }

    public void setBirthDate(final Date birthDate) {
        this.birthDate = new Date(birthDate.getTime());
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(final Gender gender) {
        this.gender = gender;
    }

    public List<String> getContactNumberList() {
        return contactNumberList;
    }

    public void setContactNumberList(List<String> contactNumberList) {
        this.contactNumberList = contactNumberList;
    }
}
