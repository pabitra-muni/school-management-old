package org.ahant.admission.controller;

import com.google.common.collect.ImmutableList;
import org.ahant.admission.model.Admission;
import org.ahant.core.exception.ApplicationException;
import org.ahant.core.model.Fee;
import org.ahant.core.model.Gender;
import org.ahant.core.model.Student;
import org.ahant.core.model.TaskData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;

import static org.ahant.admission.constants.AdmissionConstants.*;
import static org.ahant.core.constants.ApplicationConstants.REQUIRED_FIELD_MISSING;
import static org.testng.Assert.*;

/**
 * Created by ahant on 8/7/2016.
 */
public class AdmissionValidatorTest {
    private AdmissionValidator validator;
    private TaskData<Admission> taskData;

    @BeforeMethod
    public void init() {
        validator = new AdmissionValidator();
        taskData = getTaskData();
    }

    @Test
    public void testValidate_nullInput() {
        taskData.setSource(null);
        validator.validate(taskData);
        assertNull(taskData.getTarget());
        assertNotNull(taskData.getException());
        assertTrue(taskData.getException() instanceof ApplicationException);
        assertEquals(taskData.getException().getMessage(), NO_ADMISSION_DETAIL_ERROR_MSG);
    }

    @Test
    public void testValidate_AdmissionDateMissing() {
        Admission admissionData = getAdmissionData();
        admissionData.setAdmissionDate(null);
        taskData.setSource(admissionData);
        validator.validate(taskData);
        assertNull(taskData.getTarget());
        assertNotNull(taskData.getException());
        assertTrue(taskData.getException() instanceof ApplicationException);
        assertEquals(taskData.getException().getMessage(), String.format(REQUIRED_FIELD_MISSING, "admissionDate"));
    }

    @Test
    public void testValidate_FeeMissing() {
        Admission admissionData = getAdmissionData();
        admissionData.setFee(null);
        taskData.setSource(admissionData);
        validator.validate(taskData);
        assertNull(taskData.getTarget());
        assertNotNull(taskData.getException());
        assertTrue(taskData.getException() instanceof ApplicationException);
        assertEquals(taskData.getException().getMessage(), String.format(REQUIRED_FIELD_MISSING, "fee"));
    }

    @Test
    public void testValidate_StudentMissing() {
        Admission admissionData = getAdmissionData();
        admissionData.setStudent(null);
        taskData.setSource(admissionData);
        validator.validate(taskData);
        assertNull(taskData.getTarget());
        assertNotNull(taskData.getException());
        assertTrue(taskData.getException() instanceof ApplicationException);
        assertEquals(taskData.getException().getMessage(), String.format(REQUIRED_FIELD_MISSING, "student"));
    }

    @Test
    public void testValidate_StandardMissing() {
        Admission admissionData = getAdmissionData();
        admissionData.getStudent().setStandard(null);
        taskData.setSource(admissionData);
        validator.validate(taskData);
        assertNull(taskData.getTarget());
        assertNotNull(taskData.getException());
        assertTrue(taskData.getException() instanceof ApplicationException);
        assertEquals(taskData.getException().getMessage(), String.format(REQUIRED_FIELD_MISSING, "standard"));
    }

    @Test
    public void testValidate_SectionMissing() {
        Admission admissionData = getAdmissionData();
        admissionData.getStudent().setSection(null);
        taskData.setSource(admissionData);
        validator.validate(taskData);
        assertNull(taskData.getTarget());
        assertNotNull(taskData.getException());
        assertTrue(taskData.getException() instanceof ApplicationException);
        assertEquals(taskData.getException().getMessage(), String.format(REQUIRED_FIELD_MISSING, "section"));
    }

    @Test
    public void testValidate_AmountMissing() {
        Admission admissionData = getAdmissionData();
        admissionData.getFee().setAmount(null);
        taskData.setSource(admissionData);
        validator.validate(taskData);
        assertNull(taskData.getTarget());
        assertNotNull(taskData.getException());
        assertTrue(taskData.getException() instanceof ApplicationException);
        assertEquals(taskData.getException().getMessage(), String.format(REQUIRED_FIELD_MISSING, "amount"));
    }

    @Test
    public void testValidate_PaymentDateMissing() {
        Admission admissionData = getAdmissionData();
        admissionData.getFee().setPaymentDate(null);
        taskData.setSource(admissionData);
        validator.validate(taskData);
        assertNull(taskData.getTarget());
        assertNotNull(taskData.getException());
        assertTrue(taskData.getException() instanceof ApplicationException);
        assertEquals(taskData.getException().getMessage(), String.format(REQUIRED_FIELD_MISSING, "paymentDate"));
    }

    @Test
    public void testValidate_ParentGuardianMissing() {
        Admission admissionData = getAdmissionData();
        admissionData.getStudent().setFatherName(null);
        admissionData.getStudent().setMotherName(null);
        admissionData.getStudent().setGuardianName(null);
        taskData.setSource(admissionData);
        validator.validate(taskData);
        assertNull(taskData.getTarget());
        assertNotNull(taskData.getException());
        assertTrue(taskData.getException() instanceof ApplicationException);
        assertEquals(taskData.getException().getMessage(), GUARDIAN_MISSING);
    }

    @Test
    public void testValidate_InvalidAdmissionDate() {
        Admission admissionData = getAdmissionData();
        admissionData.setAdmissionDate(getTomorrow());
        taskData.setSource(admissionData);
        validator.validate(taskData);
        assertNull(taskData.getTarget());
        assertNotNull(taskData.getException());
        assertTrue(taskData.getException() instanceof ApplicationException);
        assertEquals(taskData.getException().getMessage(), ADMISSION_DATE_ERROR);
    }

    @Test
    public void testValidate_BirthDateMissing() {
        Admission admissionData = getAdmissionData();
        admissionData.getStudent().setBirthDate(null);
        taskData.setSource(admissionData);
        validator.validate(taskData);
        assertNull(taskData.getTarget());
        assertNotNull(taskData.getException());
        assertTrue(taskData.getException() instanceof ApplicationException);
        assertEquals(taskData.getException().getMessage(), BIRTH_DATE_ERROR);
    }

    @Test
    public void testValidate_AllGood() {
        Admission admissionData = getAdmissionData();
        taskData.setSource(admissionData);
        validator.validate(taskData);
        assertNull(taskData.getTarget());
        assertNull(taskData.getException());
    }

    private Admission getAdmissionData() {
        Admission admission = new Admission();
        admission.setAdmissionDate(new Date());
        admission.setFee(getFeeData());
        admission.setStudent(getStudentData());
        return admission;
    }

    private Student getStudentData() {
        Student student = new Student();
        student.setFullName("Ahalya Muni");
        student.setBirthDate(new Date());
        student.setGender(Gender.FEMALE);
        student.setContactNumberList(ImmutableList.of("8978889915"));
        student.setFatherName("Raghunath Behera");
        student.setStandard("5");
        student.setSection("C");
        return student;
    }

    private Fee getFeeData() {
        Fee fee = new Fee();
        fee.setAmount(1000d);
        fee.setPaymentDate(new Date());
        return fee;
    }

    private TaskData<Admission> getTaskData() {
        return new TaskData<>();
    }

    private Date getTomorrow() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return calendar.getTime();
    }
}
