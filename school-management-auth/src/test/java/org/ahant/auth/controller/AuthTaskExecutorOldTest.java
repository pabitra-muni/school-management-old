package org.ahant.auth.controller;

import org.ahant.auth.dao.authDao;
import org.ahant.auth.exception.InvalidCredentialException;
import org.ahant.auth.model.User;
import org.ahant.core.util.cipher.Encryptor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;

import static org.ahant.auth.constants.AuthConstants.INVALID_CREDENTIAL;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;

/**
 * Created by ahant on 3/19/2016.
 */
public class AuthTaskExecutorOldTest {

    private AuthTaskExecutorOld loginValidator;
    private authDao mockAuthDao;
    private static final String testUsername = "testUsername";
    private static final String testPassword = "testPassword";

    @BeforeMethod
    public void setUp() {
        loginValidator = new AuthTaskExecutorOld();
    }

    @Test(expectedExceptions = {
            IllegalArgumentException.class})
    public void testValidateUser_UserNull() {
        loginValidator.isValidUser(null);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class}, expectedExceptionsMessageRegExp = INVALID_CREDENTIAL)
    public void testValidateUser_UsernameNull() {
        loginValidator.isValidUser(new User(null, testPassword));
    }

    @Test(expectedExceptions = {IllegalArgumentException.class}, expectedExceptionsMessageRegExp = INVALID_CREDENTIAL)
    public void testValidateUser_EmptyUserName() {
        loginValidator.isValidUser(new User("", testPassword));
    }

    @Test(expectedExceptions = {IllegalArgumentException.class}, expectedExceptionsMessageRegExp = INVALID_CREDENTIAL)
    public void testValidateUser_EmptyPassword() {
        loginValidator.isValidUser(new User(testUsername, ""));
    }

    @Test(expectedExceptions = {IllegalArgumentException.class}, expectedExceptionsMessageRegExp = INVALID_CREDENTIAL)
    public void testValidateUser_PasswordNull() {
        loginValidator.isValidUser(new User(testUsername, null));
    }

    @Test(expectedExceptions = {InvalidCredentialException.class}, expectedExceptionsMessageRegExp = INVALID_CREDENTIAL)
    public void testValidateUser_IncorrectPassword() throws UnsupportedEncodingException {

        mockAuthDao = mock(authDao.class);
        when(mockAuthDao.getPassword(testUsername)).thenReturn(Encryptor.encode("wrongPassword"));
        loginValidator.setAuthDao(mockAuthDao);

        loginValidator.isValidUser(new User(testUsername, testPassword));
    }

    @Test
    public void testValidateUser_ValidUserDetails() throws UnsupportedEncodingException {
        mockAuthDao = mock(authDao.class);
        when(mockAuthDao.getPassword(testUsername)).thenReturn(Encryptor.encode(testPassword));
        loginValidator.setAuthDao(mockAuthDao);
        assertTrue(loginValidator.isValidUser(new User(testUsername, testPassword)));
    }
}
