package org.ahant.auth.controller;

import com.google.common.base.Strings;
import org.ahant.auth.dao.LoginDao;
import org.ahant.auth.exception.InvalidCredentialException;
import org.ahant.auth.model.User;
import org.ahant.core.exception.ApplicationException;
import org.ahant.core.util.cipher.Encryptor;

import static com.google.common.base.Preconditions.checkArgument;
import static org.ahant.auth.constants.LoginConstants.INVALID_CREDENTIAL;

/**
 * Created by ahant on 3/19/2016.
 */
public class LoginValidatorImpl implements LoginValidator {

    private LoginDao loginDao;

    @Override
    public boolean validateUser(User user) {
        sanityCheck(user);
        if (!user.getPassword().equals(Encryptor.decode(loginDao.getPassword(user.getUserName())))) {
            throw new InvalidCredentialException(INVALID_CREDENTIAL);
        }
        return true;
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
