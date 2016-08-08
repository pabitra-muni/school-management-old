package org.ahant.admission.controller;

import org.ahant.admission.model.Admission;
import org.ahant.core.controller.DataValidator;
import org.ahant.core.exception.ApplicationException;
import org.ahant.core.model.TaskData;

import static org.ahant.admission.constants.AdmissionConstants.NO_ADMISSION_DETAIL_ERROR_MSG;
import static org.ahant.core.util.CommonUtil.buildException;

/**
 * Created by ahant on 8/2/2016.
 */
public class AdmissionValidator implements DataValidator<Admission> {

    @Override
    public boolean validate(TaskData<Admission> taskData) {
        boolean returnValue = false;

        Admission admission = taskData.getSource();
        if (admission != null) {

        } else {
            taskData.setException(buildException(ApplicationException.class, NO_ADMISSION_DETAIL_ERROR_MSG));
        }


        return returnValue;
    }
}
