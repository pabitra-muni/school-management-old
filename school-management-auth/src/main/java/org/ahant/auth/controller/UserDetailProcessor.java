package org.ahant.auth.controller;

import org.ahant.auth.dao.AuthDao1;
import org.ahant.auth.model.User;
import org.ahant.core.controller.DataProcessor;
import org.ahant.core.exception.NotFoundException;
import org.ahant.core.model.TaskData;

import static org.ahant.auth.constants.AuthConstants.USER_NOT_FOUND;

/**
 * Created by ahant on 7/27/2016.
 */
public class UserDetailProcessor implements DataProcessor {
    private AuthDao1 authDao;

    @Override
    public void process(TaskData taskData) {
        final User user = (User) taskData.getSource();
        final User userDetails = authDao.getUserDetails(user.getUserName());
        if (null == userDetails) {
            taskData.setException(new NotFoundException(String.format(USER_NOT_FOUND, user.getUserName())));
        } else {
            taskData.setTarget(userDetails);
        }
    }

    public void setAuthDao(AuthDao1 authDao) {
        this.authDao = authDao;
    }
}
