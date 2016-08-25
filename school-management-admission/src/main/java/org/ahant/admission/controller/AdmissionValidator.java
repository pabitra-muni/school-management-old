package org.ahant.admission.controller;

import org.ahant.admission.model.Admission;
import org.ahant.core.controller.DataValidator;
import org.ahant.core.model.Student;
import org.ahant.core.model.TaskData;
import org.ahant.core.validation.FieldValidationType;
import org.ahant.core.validation.util.RequiredFieldValidator;

import java.util.Date;
import java.util.Set;

import static org.ahant.admission.constants.AdmissionConstants.*;
import static org.ahant.core.util.CommonUtil.*;

/**
 * Created by ahant on 8/2/2016.
 */
public class AdmissionValidator implements DataValidator<Admission> {

    @Override
    public void validate(TaskData<Admission> taskData) {
        final Admission admission = taskData.getSource();
        if (admission != null) {
            try {
                Set<String> errors = RequiredFieldValidator.validate(admission, FieldValidationType.FAIL_FAST);
                if (isSuccessful(errors)) {
                    // field validation was successful, do business validations.
                    if (isNotBlank(performBusinessValidation(admission))) {
                        setException(taskData, errors.iterator().next());
                    }
                } else {
                    // field validation failed, set exception
                    setException(taskData, errors.iterator().next());
                }


            } catch (RuntimeException ex) {
                setException(taskData, ex.getMessage());
            }
        } else {
            setException(taskData, NO_ADMISSION_DETAIL_ERROR_MSG);
        }
    }

    private String performBusinessValidation(final Admission admission) {
        Student student = admission.getStudent();
        if (student.getFatherName() == null && student.getMotherName() == null && student.getGuardianName() == null) {
            return GUARDIAN_MISSING;
        }
        // admission date should not be a previous date, should be today or a post date.
        if (isLaterDate(new Date(), admission.getAdmissionDate())) {
            return ADMISSION_DATE_ERROR;
        }

        if(admission.getStudent().getBirthDate() == null){
            return BIRTH_DATE_ERROR;
        }
        return null;
    }
}
