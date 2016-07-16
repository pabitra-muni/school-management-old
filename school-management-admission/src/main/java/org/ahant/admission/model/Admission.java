package org.ahant.admission.model;

import org.ahant.core.model.Fee;
import org.ahant.core.model.Student;

import java.util.Date;

/**
 * Created by ahant on 7/16/2016.
 */
public class Admission {
    String admissionNumber;
    Date admissionDate;
    Student student;
    Fee fee;
    String remarks;
}
