package org.ahant.auth.controller;

import org.ahant.core.controller.DataValidator;
import org.ahant.core.model.TaskData;

/**
 * Created by ahant on 7/27/2016.
 */
public class UserDetailValidator implements DataValidator {

    @Override
    public boolean validate(TaskData taskData) {
        return AuthValidator.isValidUserInput(taskData, false);
    }
}
