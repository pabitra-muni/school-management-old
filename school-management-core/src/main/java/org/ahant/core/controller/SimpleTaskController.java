package org.ahant.core.controller;

import org.ahant.core.exception.ApplicationException;
import org.ahant.core.model.Input;
import org.ahant.core.model.Result;
import org.ahant.core.model.TaskData;

import static org.ahant.core.util.CommonUtil.buildException;

/**
 * Created by ahant on 7/27/2016.
 */
public class SimpleTaskController<T extends Input> implements TaskController<T> {

    TaskExecutor<T> executor;

    @Override
    public Result executeTask(TaskData<T> taskData) {
        Result result;
        if (taskData != null) {
            executor.validate(taskData);
            if (taskData.getException() == null) {
                executor.process(taskData);
            }
            result = executor.buildResult(taskData);
        } else {
            result = buildException(ApplicationException.class, "");
        }
        return result;
    }

    public void setExecutor(TaskExecutor<T> executor) {
        this.executor = executor;
    }
}
