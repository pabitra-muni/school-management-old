package org.ahant.core.controller;

import org.ahant.core.exception.ApplicationException;
import org.ahant.core.exception.NotFoundException;
import org.ahant.core.model.Result;
import org.ahant.core.model.Student;
import org.ahant.core.model.TaskData;
import org.mockito.InOrder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

/**
 * Created by ahant on 7/31/2016.
 */
public class SimpleTaskControllerTest {
    private SimpleTaskController taskController;
    private TaskExecutor taskExecutor;

    @BeforeMethod
    public void init() {
        taskController = new SimpleTaskController();
        taskExecutor = getMockExecutor();
        taskController.setExecutor(taskExecutor);
    }

    @Test
    public void testExecuteTask_TaskDataNull() {
        taskController.setExecutor(getMockExecutor());
        Result result = taskController.executeTask(null);
        assertNotNull(result);
        assertTrue(result instanceof ApplicationException);
        verifyZeroInteractions(taskExecutor);
    }

    @Test
    public void testExecuteTask_ValidateReturnsFalse() {
        when(taskExecutor.validate(any(TaskData.class))).thenReturn(false);
        when(taskExecutor.buildResult(any(TaskData.class))).thenReturn(getExceptionResult());
        Result result = taskController.executeTask(getTaskData());
        assertNotNull(result);
        assertTrue(result instanceof ApplicationException);
        verify(taskExecutor, atMost(1)).validate(any(TaskData.class));
        verify(taskExecutor, atMost(1)).buildResult(any(TaskData.class));
        verify(taskExecutor, never()).process(any(TaskData.class));

        InOrder inOrder = inOrder(taskExecutor);
        inOrder.verify(taskExecutor).validate(any(TaskData.class));
        inOrder.verify(taskExecutor).buildResult(any(TaskData.class));
    }

    @Test
    public void testExecuteTask_ValidateReturnsTrueButException() {
        when(taskExecutor.validate(any(TaskData.class))).thenReturn(true);
        when(taskExecutor.buildResult(any(TaskData.class))).thenReturn(getExceptionResult());
        Result result = taskController.executeTask(getTaskDataWithException());
        assertNotNull(result);
        assertTrue(result instanceof ApplicationException);
        verify(taskExecutor, atMost(1)).validate(any(TaskData.class));
        verify(taskExecutor, atMost(1)).buildResult(any(TaskData.class));
        verify(taskExecutor, never()).process(any(TaskData.class));

        InOrder inOrder = inOrder(taskExecutor);
        inOrder.verify(taskExecutor).validate(any(TaskData.class));
        inOrder.verify(taskExecutor).buildResult(any(TaskData.class));
    }

    @Test
    public void testExecuteTask_ValidateReturnsTrue() {
        when(taskExecutor.validate(any(TaskData.class))).thenReturn(true);
        when(taskExecutor.buildResult(any(TaskData.class))).thenReturn(getResult());
        doNothing().when(taskExecutor).process(any(TaskData.class));
        Result result = taskController.executeTask(getTaskData());
        assertNotNull(result);
        assertTrue(result instanceof Student);
        verify(taskExecutor, atMost(1)).validate(any(TaskData.class));
        verify(taskExecutor, atMost(1)).process(any(TaskData.class));
        verify(taskExecutor, atMost(1)).buildResult(any(TaskData.class));

        InOrder inOrder = inOrder(taskExecutor);
        inOrder.verify(taskExecutor).validate(any(TaskData.class));
        inOrder.verify(taskExecutor).process(any(TaskData.class));
        inOrder.verify(taskExecutor).buildResult(any(TaskData.class));
    }

    private TaskExecutor getMockExecutor() {
        return mock(TaskExecutor.class);
    }

    private TaskData getTaskData() {
        return mock(TaskData.class);
    }

    private TaskData getTaskDataWithException() {
        TaskData data = new TaskData();
        data.setException(new NotFoundException(""));
        return data;
    }

    private Result getResult() {
        return mock(Student.class);
    }

    private Result getExceptionResult() {
        return mock(ApplicationException.class);
    }
}
