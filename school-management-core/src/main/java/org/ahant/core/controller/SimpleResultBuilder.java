package org.ahant.core.controller;

import org.ahant.core.exception.ApplicationException;
import org.ahant.core.model.Result;
import org.ahant.core.model.TaskData;

/**
 * Created by ahant on 7/27/2016.
 */
public class SimpleResultBuilder implements ResultBuilder {
    @Override
    public Result buildResult(TaskData taskData) {
        Result finalResult = taskData.getException();
        if (finalResult == null) {
            finalResult = taskData.getTarget();
        }
        return (finalResult != null) ? finalResult : new ApplicationException();
    }
}
