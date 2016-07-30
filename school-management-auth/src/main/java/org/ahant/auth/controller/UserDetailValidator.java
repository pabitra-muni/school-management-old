package org.ahant.auth.controller;

import com.google.common.base.Strings;
import org.ahant.auth.exception.InvalidCredentialException;
import org.ahant.auth.model.User;
import org.ahant.core.controller.DataValidator;
import org.ahant.core.exception.ApplicationException;
import org.ahant.core.model.TaskData;

import static org.ahant.auth.constants.AuthConstants.NO_USER;
import static org.ahant.auth.constants.AuthConstants.NO_USER_NAME;

/**
 * Created by ahant on 7/27/2016.
 */
public class UserDetailValidator implements DataValidator {

    @Override
    public boolean validate(TaskData taskData) {
        boolean returnValue = false;
        Object source = taskData.getSource();
        if (source != null && source instanceof User) {
            User user = (User) source;
            if (Strings.isNullOrEmpty(user.getUserName())) {
                taskData.setException(new InvalidCredentialException(NO_USER_NAME));
            } else {
                returnValue = true;
            }
        } else {
            taskData.setException(new ApplicationException(NO_USER));
        }

        return returnValue;
    }
}
