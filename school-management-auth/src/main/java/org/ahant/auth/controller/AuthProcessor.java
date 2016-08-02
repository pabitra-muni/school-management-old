package org.ahant.auth.controller;

import org.ahant.auth.dao.AuthDao1;
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
public class AuthProcessor implements DataProcessor {
    private AuthDao1 authDao;

    @Override
    public void process(TaskData taskData) {
        final User user = (User) taskData.getSource();
        if (!user.getPassword().equals(Encryptor.decode(authDao.getPassword(user.getUserName())))) {
            taskData.setException(new InvalidCredentialException(INVALID_CREDENTIAL));
        } else {
            taskData.setTarget(new EmptyResult());
        }
    }

    public void setAuthDao(AuthDao1 authDao) {
        this.authDao = authDao;
    }
}
