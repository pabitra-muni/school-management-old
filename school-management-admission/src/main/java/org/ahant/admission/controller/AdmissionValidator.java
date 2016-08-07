package org.ahant.admission.controller;

import org.ahant.admission.model.Admission;
import org.ahant.core.controller.DataValidator;
import org.ahant.core.model.TaskData;

/**
 * Created by ahant on 8/2/2016.
 */
public class AdmissionValidator implements DataValidator<Admission> {

    @Override
    public boolean validate(TaskData<Admission> taskData) {
        boolean returnValue = false;

        Admission admission = taskData.getSource();



        return returnValue;
    }
}
