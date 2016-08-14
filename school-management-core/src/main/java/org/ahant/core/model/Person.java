package org.ahant.core.model;

import org.ahant.core.annotation.Field;
import org.ahant.core.annotation.Required;

import java.util.Date;
import java.util.List;

/**
 * Created by ahant on 7/24/2016.
 */
@Required
public class Person {
    private String fullName;
    private Date birthDate;
    private Gender gender;
    @Field(name = "contactNumber")
    private List<String> contactNumberList;
    @Field(name = "identificationMark")
    private List<String> identificationMarkList;
    private Address address;
    @Field(optional = true)
    private String emailAddress;

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
