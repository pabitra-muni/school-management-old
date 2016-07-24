package org.ahant.auth.controller;

import com.google.common.base.Strings;
import org.ahant.auth.dao.LoginDao;
import org.ahant.auth.exception.InvalidCredentialException;
import org.ahant.auth.model.User;
import org.ahant.core.exception.NotFoundException;
import org.ahant.core.util.cipher.Encryptor;

import static com.google.common.base.Preconditions.checkArgument;
import static org.ahant.auth.constants.LoginConstants.INVALID_CREDENTIAL;
import static org.ahant.auth.constants.LoginConstants.MISSING_USER_NAME;
import static org.ahant.auth.constants.LoginConstants.USER_NOT_FOUND;

/**
 * Created by ahant on 3/19/2016.
 */
public class LoginControllerImpl implements LoginController {

    private LoginDao loginDao;

    @Override
    public boolean isValidUser(User user){
        sanityCheck(user);
        if (!user.getPassword().equals(Encryptor.decode(loginDao.getPassword(user.getUserName())))) {
            throw new InvalidCredentialException(INVALID_CREDENTIAL);
        }
        return true;
    }

    @Override
    public User getUserDetails(final User user) {
        checkArgument(null != user);
        checkArgument(!Strings.isNullOrEmpty(user.getUserName()), MISSING_USER_NAME);
        User userInfo = loginDao.getUserDetails(user.getUserName());
        if(null == user){
            throw new NotFoundException(String.format(USER_NOT_FOUND, user.getUserName()));
        }
        return userInfo;
    }

    @Override
    public User validateAndGetDetails(User user) {
        return null;
    }

    private void sanityCheck(User user) {
        checkArgument(null != user);
        checkArgument(!Strings.isNullOrEmpty(user.getUserName()), INVALID_CREDENTIAL);
        checkArgument(!Strings.isNullOrEmpty(user.getPassword()), INVALID_CREDENTIAL);
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
}
