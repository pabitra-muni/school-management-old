package org.ahant.core.model;

import com.github.ahant.validator.annotation.CollectionType;
import com.github.ahant.validator.annotation.FieldInfo;

import java.util.Date;
import java.util.List;

import static com.github.ahant.validator.validation.FieldValidatorType.CUSTOM;
import static com.github.ahant.validator.validation.FieldValidatorType.EMAIL;
import static com.github.ahant.validator.validation.FieldValidatorType.PHONE;
import static com.github.ahant.validator.validation.FieldValidatorType.STRING;

/**
 * Created by ahant on 7/24/2016.
 */
public class Person {
    @FieldInfo(validatorType = STRING, optional = false)
    private String fullName;
    private Date birthDate;
    @FieldInfo(optional = false)
    private Gender gender;
    @FieldInfo(name = "contactNumber", validatorType = PHONE, optional = false)
    @CollectionType
    private List<String> contactNumberList;
    @FieldInfo(name = "identificationMark", validatorType = STRING)
    @CollectionType
    private List<String> identificationMarkList;
    @FieldInfo(validatorType = CUSTOM, optional = false)
    private Address address;
    @FieldInfo(name = "email", validatorType = EMAIL)
    private String emailAddress;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate != null ? new Date(birthDate.getTime()) : null;
    }

    public void setBirthDate(final Date birthDate) {
        this.birthDate = birthDate;
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

    public List<String> getIdentificationMarkList() {
        return identificationMarkList;
    }

    public void setIdentificationMarkList(List<String> identificationMarkList) {
        this.identificationMarkList = identificationMarkList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
