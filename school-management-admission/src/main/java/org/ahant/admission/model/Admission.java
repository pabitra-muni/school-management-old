package org.ahant.admission.model;

import org.ahant.core.model.Fee;
import org.ahant.core.model.Student;

import java.util.Date;

/**
 * Created by ahant on 7/16/2016.
 */
public class Admission {
    private String admissionNumber;
    private Date admissionDate;
    private Student student;
    private Fee fee;
    private String remarks;

    public String getAdmissionNumber() {
        return admissionNumber;
    }

    public void setAdmissionNumber(String admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public Date getAdmissionDate() {
        return admissionDate;
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
