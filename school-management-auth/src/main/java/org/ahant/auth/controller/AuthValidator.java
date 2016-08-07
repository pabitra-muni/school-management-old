package org.ahant.auth.controller;

import com.google.common.base.Strings;
import org.ahant.auth.exception.InvalidCredentialException;
import org.ahant.auth.model.User;
import org.ahant.core.controller.DataValidator;
import org.ahant.core.exception.ApplicationException;
import org.ahant.core.model.TaskData;

import static org.ahant.auth.constants.AuthConstants.INVALID_CREDENTIAL;
import static org.ahant.auth.constants.AuthConstants.NO_USER;

/**
 * Created by ahant on 7/27/2016.
 */
public class AuthValidator implements DataValidator<User> {

    @Override
    public boolean validate(TaskData<User> taskData) {
        return isValidUserInput(taskData, true);
    }

    static boolean isValidUserInput(TaskData<User> taskData, boolean isPasswordValidationRequired) {
        boolean returnValue = false;
        User user = taskData.getSource();
        if(user !=null) {
            if (Strings.isNullOrEmpty(user.getUserName()) || (isPasswordValidationRequired ? Strings.isNullOrEmpty(user.getPassword()) : false)) {
                taskData.setException(new InvalidCredentialException(INVALID_CREDENTIAL));
            } else {
                returnValue = true;
            }
        }else{
            taskData.setException(new ApplicationException(NO_USER));
        }
        return returnValue;
    }
}
