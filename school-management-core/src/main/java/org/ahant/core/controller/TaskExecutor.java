package org.ahant.core.controller;

import org.ahant.core.model.Result;
import org.ahant.core.model.TaskData;

/**
 * Created by ahant on 7/27/2016.
 */
public interface TaskExecutor {

    boolean validate(TaskData taskData);
    void process(TaskData taskData);
    Result buildResult(TaskData taskData);

}
