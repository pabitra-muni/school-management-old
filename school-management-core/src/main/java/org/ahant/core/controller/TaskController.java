package org.ahant.core.controller;

import org.ahant.core.model.Input;
import org.ahant.core.model.Result;
import org.ahant.core.model.TaskData;

/**
 * Created by ahant on 7/27/2016.
 */
@FunctionalInterface
public interface TaskController<T extends Input> {
    Result executeTask(TaskData<T> taskData);
}
