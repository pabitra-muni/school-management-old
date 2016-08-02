package org.ahant.auth.controller;

import org.ahant.auth.dao.AuthDao;
import org.ahant.auth.exception.InvalidCredentialException;
import org.ahant.auth.model.User;
import org.ahant.core.model.EmptyResult;
import org.ahant.core.model.Result;
import org.ahant.core.model.TaskData;
import org.ahant.core.util.cipher.Encryptor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;

import static org.ahant.auth.constants.AuthConstants.INVALID_CREDENTIAL;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

/**
 * Created by ahant on 7/30/2016.
 */
public class AuthProcessorTest {
    private AuthProcessor authProcessor;
    private AuthDao mockAuthDao;
    private static final String testUsername = "testUsername";
    private static final String testPassword = "testPassword";
    private static final String wrongPassword = "wrongPassword";

    @BeforeMethod
    public void setUp() {
        authProcessor = new AuthProcessor();
    }

    @Test
    public void testValidateUser_ValidUser() throws UnsupportedEncodingException {
        mockAuthDao = mock(AuthDao.class);
        when(mockAuthDao.getPassword(testUsername)).thenReturn(Encryptor.encode(testPassword));
        authProcessor.setAuthDao(mockAuthDao);
        TaskData data = getTaskData();
        authProcessor.process(data);
        assertNull(data.getException());
        Result target = data.getTarget();
        assertNotNull(target);
        assertTrue(target instanceof EmptyResult);
    }

    @Test
    public void testValidateUser_InvalidUser() throws UnsupportedEncodingException {
        mockAuthDao = mock(AuthDao.class);
        when(mockAuthDao.getPassword(testUsername)).thenReturn(Encryptor.encode(wrongPassword));
        authProcessor.setAuthDao(mockAuthDao);
        TaskData data = getTaskData();
        authProcessor.process(data);
        assertNotNull(data.getException());
        assertTrue(data.getException() instanceof InvalidCredentialException);
        String errorMsg = data.getException().getMessage();
        assertNotNull(errorMsg);
        assertEquals(errorMsg, INVALID_CREDENTIAL);
    }

    private TaskData getTaskData() {
        TaskData data = new TaskData();
        data.setSource(new User(testUsername, testPassword));
        return data;
    }
}
