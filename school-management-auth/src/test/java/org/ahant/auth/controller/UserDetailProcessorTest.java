package org.ahant.auth.controller;

import org.ahant.auth.dao.AuthDao1;
import org.ahant.auth.model.User;
import org.ahant.core.exception.NotFoundException;
import org.ahant.core.model.TaskData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.ahant.auth.constants.AuthConstants.USER_NOT_FOUND;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

/**
 * Created by ahant on 7/31/2016.
 */
public class UserDetailProcessorTest {
    private UserDetailProcessor userDetailProcessor;
    private AuthDao1 authDao;
    private static final String testUsername = "testUsername";

    @BeforeMethod
    public void setUp() {
        userDetailProcessor = new UserDetailProcessor();
        authDao = mock(AuthDao1.class);
        userDetailProcessor.setAuthDao(authDao);
    }

    @Test
    public void testGetUserDetails_UserNotFound() {
        TaskData data = getTaskData();
        when(authDao.getUserDetails(testUsername)).thenReturn(null);
        userDetailProcessor.process(data);
        assertNotNull(data.getException());
        assertTrue(data.getException() instanceof NotFoundException);
        String errorMsg = data.getException().getMessage();
        assertNotNull(errorMsg);
        assertEquals(errorMsg, String.format(USER_NOT_FOUND, testUsername));
    }

    @Test
    public void testGetUserDetails_UserFound() {
        TaskData data = getTaskData();
        when(authDao.getUserDetails(testUsername)).thenReturn(new User(null, null));
        userDetailProcessor.process(data);
        assertNull(data.getException());
        assertNotNull(data.getTarget());
        assertTrue(data.getTarget() instanceof User);
    }

    private TaskData getTaskData() {
        TaskData data = new TaskData();
        data.setSource(new User(testUsername, null));
        return data;
    }
}
