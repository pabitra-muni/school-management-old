package org.ahant.admission.controller;

import org.ahant.admission.model.Admission;
import org.ahant.core.exception.ApplicationException;
import org.ahant.core.model.TaskData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.ahant.admission.constants.AdmissionConstants.NO_ADMISSION_DETAIL_ERROR_MSG;
import static org.testng.Assert.*;

/**
 * Created by ahant on 8/7/2016.
 */
public class AdmissionValidatorTest {
    private AdmissionValidator validator;
    private TaskData<Admission> taskData;

    @BeforeMethod
    public void init(){
        validator = new AdmissionValidator();
        taskData = getTaskData();
    }

    @Test
    public void testValidate_nullInput(){
        taskData.setSource(null);
        boolean result = validator.validate(taskData);
        assertFalse(result);
        assertNull(taskData.getTarget());
        assertNotNull(taskData.getException());
        assertTrue(taskData.getException() instanceof ApplicationException);
        assertEquals(taskData.getException().getMessage(), NO_ADMISSION_DETAIL_ERROR_MSG);
    }

    private TaskData<Admission> getTaskData(){ return new TaskData<Admission>();}
}
