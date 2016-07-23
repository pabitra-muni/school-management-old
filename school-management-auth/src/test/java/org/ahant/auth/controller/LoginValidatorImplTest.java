package org.ahant.auth.controller;

import org.ahant.auth.dao.LoginDao;
import org.ahant.core.exception.ApplicationException;
import org.ahant.auth.exception.InvalidCredentialException;
import org.ahant.auth.model.User;
import org.ahant.core.util.cipher.Encryptor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;

import static org.ahant.auth.constants.LoginConstants.INVALID_CREDENTIAL;
import static org.ahant.auth.constants.LoginConstants.NO_USER;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;

/**
 * Created by ahant on 3/19/2016.
 */
public class LoginValidatorImplTest {

    private LoginValidatorImpl loginValidator;
    private LoginDao mockLoginDao;
    private static final String testUsername = "testUsername";
    private static final String testPassword = "testPassword";

    @BeforeMethod
    public void setUp() {
        loginValidator = new LoginValidatorImpl();
    }

    @Test(expectedExceptions = {
            IllegalArgumentException.class})
    public void testValidateUser_UserNull() {
        loginValidator.validateUser(null);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class}, expectedExceptionsMessageRegExp = INVALID_CREDENTIAL)
    public void testValidateUser_UsernameNull() {
        loginValidator.validateUser(new User(null, testPassword));
    }

    @Test(expectedExceptions = {IllegalArgumentException.class}, expectedExceptionsMessageRegExp = INVALID_CREDENTIAL)
    public void testValidateUser_EmptyUserName() {
        loginValidator.validateUser(new User("", testPassword));
    }

    @Test(expectedExceptions = {IllegalArgumentException.class}, expectedExceptionsMessageRegExp = INVALID_CREDENTIAL)
    public void testValidateUser_EmptyPassword() {
        loginValidator.validateUser(new User(testUsername, ""));
    }

    @Test(expectedExceptions = {IllegalArgumentException.class}, expectedExceptionsMessageRegExp = INVALID_CREDENTIAL)
    public void testValidateUser_PasswordNull() {
        loginValidator.validateUser(new User(testUsername, null));
    }

    @Test(expectedExceptions = {InvalidCredentialException.class}, expectedExceptionsMessageRegExp = INVALID_CREDENTIAL)
    public void testValidateUser_IncorrectPassword() throws UnsupportedEncodingException {

        mockLoginDao = mock(LoginDao.class);
        when(mockLoginDao.getPassword(testUsername)).thenReturn(Encryptor.encode("wrongPassword"));
        loginValidator.setLoginDao(mockLoginDao);

        loginValidator.validateUser(new User(testUsername, testPassword));
    }

    @Test
    public void testValidateUser_ValidUserDetails() throws UnsupportedEncodingException {
        mockLoginDao = mock(LoginDao.class);
        when(mockLoginDao.getPassword(testUsername)).thenReturn(Encryptor.encode(testPassword));
        loginValidator.setLoginDao(mockLoginDao);
        assertTrue(loginValidator.validateUser(new User(testUsername, testPassword)));
    }
}
