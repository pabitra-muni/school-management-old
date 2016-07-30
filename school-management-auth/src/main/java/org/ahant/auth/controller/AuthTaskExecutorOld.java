package org.ahant.auth.controller;

import com.google.common.base.Strings;
import org.ahant.auth.dao.authDao;
import org.ahant.auth.exception.InvalidCredentialException;
import org.ahant.auth.model.User;
import org.ahant.core.exception.NotFoundException;
import org.ahant.core.util.cipher.Encryptor;

import static com.google.common.base.Preconditions.checkArgument;
import static org.ahant.auth.constants.AuthConstants.INVALID_CREDENTIAL;
import static org.ahant.auth.constants.AuthConstants.MISSING_USER_NAME;
import static org.ahant.auth.constants.AuthConstants.USER_NOT_FOUND;

/**
 * Created by ahant on 3/19/2016.
 */
public class AuthTaskExecutorOld {

    private authDao authDao;

    public boolean isValidUser(User user){
        sanityCheck(user);
        if (!user.getPassword().equals(Encryptor.decode(authDao.getPassword(user.getUserName())))) {
            throw new InvalidCredentialException(INVALID_CREDENTIAL);
        }
        return true;
    }


    public User getUserDetails(final User user) {
        checkArgument(null != user);
        checkArgument(!Strings.isNullOrEmpty(user.getUserName()), MISSING_USER_NAME);
        User userInfo = authDao.getUserDetails(user.getUserName());
        if(null == user){
            throw new NotFoundException(String.format(USER_NOT_FOUND, user.getUserName()));
        }
        return userInfo;
    }


    public User validateAndGetDetails(User user) {
        return null;
    }

    private void sanityCheck(User user) {
        checkArgument(null != user);
        checkArgument(!Strings.isNullOrEmpty(user.getUserName()), INVALID_CREDENTIAL);
        checkArgument(!Strings.isNullOrEmpty(user.getPassword()), INVALID_CREDENTIAL);
    }

    public void setAuthDao(authDao authDao) {
        this.authDao = authDao;
    }

}
