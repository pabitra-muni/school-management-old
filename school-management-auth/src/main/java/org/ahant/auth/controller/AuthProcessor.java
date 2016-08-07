package org.ahant.auth.controller;

import org.ahant.auth.dao.AuthDao;
import org.ahant.auth.exception.InvalidCredentialException;
import org.ahant.auth.model.User;
import org.ahant.core.controller.DataProcessor;
import org.ahant.core.model.EmptyResult;
import org.ahant.core.model.TaskData;
import org.ahant.core.util.cipher.Encryptor;

import static org.ahant.auth.constants.AuthConstants.INVALID_CREDENTIAL;

/**
 * Created by ahant on 7/27/2016.
 */
public class AuthProcessor implements DataProcessor<User> {
    private AuthDao authDao;

    @Override
    public void process(TaskData<User> taskData) {
        final User user = taskData.getSource();
        if (!user.getPassword().equals(Encryptor.decode(authDao.getPassword(user.getUserName())))) {
            taskData.setException(new InvalidCredentialException(INVALID_CREDENTIAL));
        } else {
            taskData.setTarget(new EmptyResult());
        }
    }

    public void setAuthDao(AuthDao authDao) {
        this.authDao = authDao;
    }
}
