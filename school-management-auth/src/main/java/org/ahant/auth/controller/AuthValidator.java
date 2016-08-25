package org.ahant.auth.controller;

import org.ahant.auth.exception.InvalidCredentialException;
import org.ahant.auth.model.User;
import org.ahant.core.controller.DataValidator;
import org.ahant.core.exception.ApplicationException;
import org.ahant.core.model.TaskData;

import static org.ahant.auth.constants.AuthConstants.INVALID_CREDENTIAL;
import static org.ahant.auth.constants.AuthConstants.NO_USER;
import static org.ahant.core.util.CommonUtil.buildException;
import static org.ahant.core.util.CommonUtil.isBlank;

/**
 * Created by ahant on 7/27/2016.
 */
public class AuthValidator implements DataValidator<User> {

    @Override
    public void validate(TaskData<User> taskData) {
        isValidUserInput(taskData, true);
    }

    protected void isValidUserInput(TaskData<User> taskData, boolean isPasswordValidationRequired) {

        User user = taskData.getSource();
        if (user != null) {
            if (isBlank(user.getUserName()) || (isPasswordValidationRequired ? isBlank(user.getPassword()) : false)) {
                taskData.setException(buildException(InvalidCredentialException.class, INVALID_CREDENTIAL));
            }
        } else {
            taskData.setException(buildException(ApplicationException.class, NO_USER));
        }
    }
}
