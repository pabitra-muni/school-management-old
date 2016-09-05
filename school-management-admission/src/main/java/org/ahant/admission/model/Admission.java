package org.ahant.admission.model;

import com.github.ahant.validator.annotation.FieldInfo;
import org.ahant.core.model.Fee;
import org.ahant.core.model.Input;
import org.ahant.core.model.Student;

import java.util.Date;

import static com.github.ahant.validator.validation.FieldValidatorType.CUSTOM;

/**
 * Created by ahant on 7/16/2016.
 */
public class Admission implements Input {
    private String admissionNumber;
    @FieldInfo(optional = false)
    private Date admissionDate;
    @FieldInfo(optional = false, validatorType = CUSTOM)
    private Student student;
    @FieldInfo(optional = false, validatorType = CUSTOM)
    private Fee fee;
    private String remarks;

    public String getAdmissionNumber() {
        return admissionNumber;
    }

    public void setAdmissionNumber(String admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public Date getAdmissionDate() {
        return new Date(admissionDate.getTime());
    }

    public void setAdmissionDate(final Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(final Student student) {
        this.student = student;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(final Fee fee) {
        this.fee = fee;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
