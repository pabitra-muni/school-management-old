package org.ahant.core.controller;

import org.ahant.core.model.Result;
import org.ahant.core.model.TaskData;

/**
 * Created by ahant on 7/27/2016.
 */
public class SimpleTaskController implements TaskController {

    TaskExecutor executor;

    @Override
    public Result executeTask(TaskData taskData) {
        boolean isValid = executor.validate(taskData);
        if (isValid && taskData.getException() == null) {
            executor.process(taskData);
        }
        return executor.buildResult(taskData);
    }

    public void setExecutor(TaskExecutor executor) {
        this.executor = executor;
    }
}
