package org.ahant.auth.controller;

import org.ahant.auth.model.User;
import org.ahant.core.model.TaskData;

/**
 * Created by ahant on 7/27/2016.
 */
public class UserDetailValidator extends AuthValidator {

    @Override
    public void validate(TaskData<User> taskData) {
        isValidUserInput(taskData, false);
    }
}
