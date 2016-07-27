package org.ahant.core.controller;

import org.ahant.core.model.Result;
import org.ahant.core.model.TaskData;

/**
 * Created by ahant on 7/27/2016.
 */
public interface ResultBuilder {

    Result buildResult(TaskData taskData);
}
