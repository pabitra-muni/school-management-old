package org.ahant.core.model;

import org.ahant.core.annotation.FieldInfo;
import org.ahant.core.annotation.Required;

import static org.ahant.core.validation.FieldValidatorType.STRING;
import static org.ahant.core.validation.FieldValidatorType.ZIP;

/**
 * Created by ahant on 7/16/2016.
 */
@Required
public class Address {
    @FieldInfo(validatorType = STRING)
    private String addressLine1;
    @FieldInfo(validatorType = STRING)
    private String addressLine2;
    @FieldInfo(validatorType = STRING)
    private String city;
    @FieldInfo(validatorType = STRING)
    private String state;
    @FieldInfo(validatorType = STRING)
    private String country;
    @FieldInfo(validatorType = ZIP)
    private String zip;

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
