package org.ahant.auth.controller;

import org.ahant.auth.dao.LoginDao;
import org.ahant.auth.model.User;
import org.ahant.core.controller.DataProcessor;
import org.ahant.core.exception.NotFoundException;
import org.ahant.core.model.TaskData;

/**
 * Created by ahant on 7/27/2016.
 */
public class AuthDataProcess implements DataProcessor {
    private LoginDao loginDao;

    @Override
    public void process(TaskData taskData) {
        final User user = (User) taskData.getSource();
        final User userDetails = loginDao.getUserDetails(user.getUserName());
        if (null == userDetails) {
            taskData.setException(new NotFoundException("user not found"));
        } else {
            taskData.setTarget(userDetails);
        }
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
}
