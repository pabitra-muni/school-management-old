package org.ahant.controller.login;

import com.google.common.base.Strings;
import org.ahant.dao.login.LoginDao;
import org.ahant.exception.ApplicationException;
import org.ahant.exception.InvalidCredentialException;
import org.ahant.model.login.User;
import org.ahant.util.cipher.Encryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.ahant.constants.login.LoginConstants.INVALID_CREDENTIAL;
import static org.ahant.constants.login.LoginConstants.NO_USER;

/**
 * Created by ahant on 3/19/2016.
 */
public class LoginValidatorImpl implements LoginValidator {

    private static Logger logger = LoggerFactory.getLogger(LoginValidatorImpl.class);

    private LoginDao loginDao;

    @Override
    public boolean validateUser(User user) throws IllegalArgumentException, InvalidCredentialException, ApplicationException {
        validateUserDetails(user);
        if (null == loginDao) {
            logger.error("loginDao is null.");
            throw new ApplicationException();
        }
        if (!user.getPassword().equals(Encryptor.decode(loginDao.getPassword(user.getUserName())))) {
            logger.info("Incorrect user details, throwing InvalidCredentialException with INVALID_CREDENTIAL message.");
            throw new InvalidCredentialException(INVALID_CREDENTIAL);
        }

        return true;
    }

    private void validateUserDetails(User user) throws IllegalArgumentException {
        if (null == user) {
            logger.info("User is null, throwing IllegalArgumentException with NO_USER message.");
            throw new IllegalArgumentException(NO_USER);
        }

        if (Strings.isNullOrEmpty(user.getUserName()) || Strings.isNullOrEmpty(user.getPassword())) {
            logger.info(
                    "Either username or password is invalid, throwing IllegalArgumentException with INVALID_CREDENTIAL message.");
            throw new IllegalArgumentException(INVALID_CREDENTIAL);
        }
    }


    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
}
