package org.ahant.auth.controller;

import com.google.common.base.Strings;
import org.ahant.auth.exception.InvalidCredentialException;
import org.ahant.auth.model.User;
import org.ahant.core.controller.DataValidator;
import org.ahant.core.model.TaskData;

import static org.ahant.auth.constants.LoginConstants.INVALID_CREDENTIAL;

/**
 * Created by ahant on 7/27/2016.
 */
public class AuthDataValidator implements DataValidator {

    @Override
    public boolean validate(TaskData taskData) {
        boolean returnValue = false;
        User user = (User) taskData.getSource();
        if (user == null || Strings.isNullOrEmpty(user.getUserName()) || Strings.isNullOrEmpty(user.getPassword())) {
            taskData.setException(new InvalidCredentialException(INVALID_CREDENTIAL));
        } else {
            returnValue = true;
        }
        return returnValue;
    }
}
