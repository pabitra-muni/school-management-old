package org.ahant.core.controller;

import org.ahant.core.exception.ApplicationException;
import org.ahant.core.exception.ResultException;
import org.ahant.core.model.Result;
import org.ahant.core.model.Student;
import org.ahant.core.model.TaskData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

/**
 * Created by ahant on 7/31/2016.
 */
public class SimpleResultBuilderTest {

    private SimpleResultBuilder resultBuilder;

    @BeforeMethod
    public void setUp() {
        resultBuilder = new SimpleResultBuilder();
    }

    @Test
    public void tesBuildResult_ExceptionPresentAndResultNull() {
        TaskData data = getTaskData();
        data.setException(getMockException());
        Result finalResult = resultBuilder.buildResult(data);
        assertNotNull(finalResult);
        assertTrue(finalResult instanceof ResultException);
    }

    @Test
    public void tesBuildResult_ExceptionPresentAndResultPresent() {
        TaskData data = getTaskData();
        data.setException(getMockException());
        data.setTarget(getMockResult());
        Result finalResult = resultBuilder.buildResult(data);
        assertNotNull(finalResult);
        assertTrue(finalResult instanceof ResultException);
    }

    @Test
    public void tesBuildResult_ExceptionNullAndResultNull() {
        TaskData data = getTaskData();
        Result finalResult = resultBuilder.buildResult(data);
        assertNotNull(finalResult);
        assertTrue(finalResult instanceof ApplicationException);
    }

    @Test
    public void tesBuildResult_ExceptionNullAndResultPresent() {
        TaskData data = getTaskData();
        data.setTarget(getMockResult());
        Result finalResult = resultBuilder.buildResult(data);
        assertNotNull(finalResult);
        assertTrue(finalResult instanceof Student);
    }

    private TaskData getTaskData() {
        return new TaskData();
    }

    private Result getMockResult() {
        return mock(Student.class);
    }

    private ResultException getMockException() {
        return mock(ResultException.class);
    }
}
