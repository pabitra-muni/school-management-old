package org.ahant.admission.controller;

import org.ahant.core.controller.DataValidator;
import org.ahant.core.model.TaskData;

/**
 * Created by ahant on 8/2/2016.
 */
public class AdmissionValidator implements DataValidator {

    @Override
    public boolean validate(TaskData taskData) {
        return false;
    }
}
