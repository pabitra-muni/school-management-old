package org.ahant.auth.controller;

import org.ahant.auth.exception.InvalidCredentialException;
import org.ahant.auth.model.User;
import org.ahant.core.exception.ApplicationException;
import org.ahant.core.model.TaskData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.ahant.auth.constants.AuthConstants.INVALID_CREDENTIAL;
import static org.ahant.auth.constants.AuthConstants.NO_USER;
import static org.testng.Assert.*;

/**
 * Created by ahant on 7/30/2016.
 */
public class AuthValidatorTest {

    private AuthValidator authValidator;
    private static final String testUsername = "testUsername";
    private static final String testPassword = "testPassword";

    @BeforeMethod
    public void setUp() {
        authValidator = new AuthValidator();
    }

    @Test
    public void testValidateUser_UserNull() {
        TaskData<User> data = getTaskData();
        data.setSource(null);
        authValidator.validate(data);
        assertNotNull(data.getException());
        assertTrue(data.getException() instanceof ApplicationException);
        String errorMsg = data.getException().getMessage();
        assertNotNull(errorMsg);
        assertEquals(errorMsg, NO_USER);
    }

    @Test
    public void testValidateUser_UsernameNull() {
        TaskData<User> data = getTaskData();
        data.setSource(new User(null, testPassword));
        authValidator.validate(data);
        assertNotNull(data.getException());
        assertTrue(data.getException() instanceof InvalidCredentialException);
        String errorMsg = data.getException().getMessage();
        assertNotNull(errorMsg);
        assertEquals(errorMsg, INVALID_CREDENTIAL);
    }

    @Test
    public void testValidateUser_EmptyUserName() {
        TaskData<User> data = getTaskData();
        data.setSource(new User("", testPassword));
        authValidator.validate(data);
        assertNotNull(data.getException());
        assertTrue(data.getException() instanceof InvalidCredentialException);
        String errorMsg = data.getException().getMessage();
        assertNotNull(errorMsg);
        assertEquals(errorMsg, INVALID_CREDENTIAL);
    }

    @Test
    public void testValidateUser_EmptyPassword() {
        TaskData<User> data = getTaskData();
        data.setSource(new User(testUsername, ""));
        authValidator.validate(data);
        assertNotNull(data.getException());
        assertTrue(data.getException() instanceof InvalidCredentialException);
        String errorMsg = data.getException().getMessage();
        assertNotNull(errorMsg);
        assertEquals(errorMsg, INVALID_CREDENTIAL);
    }

    @Test
    public void testValidateUser_PasswordNull() {
        TaskData<User> data = getTaskData();
        data.setSource(new User(testUsername, null));
        authValidator.validate(data);
        assertNotNull(data.getException());
        assertTrue(data.getException() instanceof InvalidCredentialException);
        String errorMsg = data.getException().getMessage();
        assertNotNull(errorMsg);
        assertEquals(errorMsg, INVALID_CREDENTIAL);
    }

    @Test
    public void testValidateUser_PasswordNull_ButNotRequired() {
        TaskData<User> data = getTaskData();
        data.setSource(new User(testUsername, null));
        authValidator.isValidUserInput(data, false);
        assertNull(data.getException());
    }

    @Test
    public void testValidateUser_ValidUserDetails() {
        TaskData<User> data = getTaskData();
        data.setSource(new User(testUsername, testPassword));
        authValidator.validate(data);
        assertNull(data.getException());
    }

    private TaskData<User> getTaskData() {
        return new TaskData<User>();
    }
}
