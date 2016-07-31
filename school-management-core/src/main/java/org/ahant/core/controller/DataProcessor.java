package org.ahant.core.controller;

import org.ahant.core.model.TaskData;

/**
 * Created by ahant on 7/27/2016.
 */
@FunctionalInterface
public interface DataProcessor {
    void process(TaskData taskData);
}
