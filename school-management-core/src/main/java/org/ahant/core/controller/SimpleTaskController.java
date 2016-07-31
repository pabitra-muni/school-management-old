package org.ahant.core.controller;

import org.ahant.core.exception.ApplicationException;
import org.ahant.core.model.Result;
import org.ahant.core.model.TaskData;

/**
 * Created by ahant on 7/27/2016.
 */
public class SimpleTaskController implements TaskController {

    TaskExecutor executor;

    @Override
    public Result executeTask(TaskData taskData) {
        Result result;
        if (taskData != null) {
            boolean isValid = executor.validate(taskData);
            if (isValid && taskData.getException() == null) {
                executor.process(taskData);
            }
            result = executor.buildResult(taskData);
        } else {
            result = new ApplicationException();
        }
        return result;
    }

    public void setExecutor(TaskExecutor executor) {
        this.executor = executor;
    }
}
