package org.ahant.admission.controller;

import com.github.ahant.validator.validation.FieldValidationType;
import com.github.ahant.validator.validation.util.RequiredFieldValidator;
import org.ahant.admission.model.Admission;
import org.ahant.core.controller.DataValidator;
import org.ahant.core.model.Student;
import org.ahant.core.model.TaskData;

import java.util.Date;
import java.util.Set;

import static org.ahant.admission.constants.AdmissionConstants.ADMISSION_DATE_ERROR;
import static org.ahant.admission.constants.AdmissionConstants.BIRTH_DATE_ERROR;
import static org.ahant.admission.constants.AdmissionConstants.GUARDIAN_MISSING;
import static org.ahant.admission.constants.AdmissionConstants.NO_ADMISSION_DETAIL_ERROR_MSG;
import static org.ahant.core.util.CommonUtil.isLaterDate;
import static org.ahant.core.util.CommonUtil.isNotBlank;
import static org.ahant.core.util.CommonUtil.isSuccessful;
import static org.ahant.core.util.CommonUtil.setException;

/**
 * Created by ahant on 8/2/2016.
 */
public class AdmissionValidator implements DataValidator<Admission> {

    @Override
    public void validate(TaskData<Admission> taskData) {
        final Admission admission = taskData.getSource();
        if (admission != null) {
            try {
                Set<String> errors = RequiredFieldValidator.INSTANCE.validate(admission, FieldValidationType.FAIL_FAST);
                if (isSuccessful(errors)) {
                    // field validation was successful, do business validations.
                    String errorMsg = performBusinessValidation(admission);
                    if (isNotBlank(errorMsg)) {
                        setException(taskData, errorMsg);
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
        // admission date should not be a future date, should be today or a past date.
        if (isLaterDate(new Date(), admission.getAdmissionDate())) {
            return ADMISSION_DATE_ERROR;
        }

        if (admission.getStudent().getBirthDate() == null) {
            return BIRTH_DATE_ERROR;
        }
        return null;
    }
}
