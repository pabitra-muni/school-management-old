package org.ahant.core.controller;

import org.ahant.core.model.Input;
import org.ahant.core.model.Result;
import org.ahant.core.model.TaskData;

/**
 * Created by ahant on 7/27/2016.
 */
public interface TaskExecutor<T extends Input> {

    boolean validate(TaskData<T> taskData);
    void process(TaskData<T> taskData);
    Result buildResult(TaskData<T> taskData);

}
