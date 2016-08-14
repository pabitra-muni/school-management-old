package org.ahant.admission.model;

import org.ahant.core.annotation.Required;
import org.ahant.core.model.Fee;
import org.ahant.core.model.Input;
import org.ahant.core.model.Student;

import java.util.Date;

/**
 * Created by ahant on 7/16/2016.
 */
public class Admission implements Input {
    private String admissionNumber;
    @Required
    private Date admissionDate;
    @Required
    private Student student;
    @Required
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
        this.admissionDate = new Date(admissionDate.getTime());
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
