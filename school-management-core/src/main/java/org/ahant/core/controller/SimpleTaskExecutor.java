package org.ahant.core.controller;

import org.ahant.core.model.Result;
import org.ahant.core.model.TaskData;

/**
 * Created by ahant on 7/27/2016.
 */
public class SimpleTaskExecutor implements TaskExecutor {

    DataValidator validator;
    DataProcessor processor;
    ResultBuilder resultBuilder;

    @Override
    public boolean validate(TaskData taskData) {
        return validator.validate(taskData);
    }

    @Override
    public void process(TaskData taskData) {
        processor.process(taskData);
    }

    @Override
    public Result buildResult(TaskData taskData) {
        return resultBuilder.buildResult(taskData);
    }

    public ResultBuilder getResultBuilder() {
        return resultBuilder;
    }

    public void setResultBuilder(ResultBuilder resultBuilder) {
        this.resultBuilder = resultBuilder;
    }

    public DataValidator getValidator() {
        return validator;
    }

    public void setValidator(DataValidator validator) {
        this.validator = validator;
    }

    public DataProcessor getProcessor() {
        return processor;
    }

    public void setProcessor(DataProcessor processor) {
        this.processor = processor;
    }
}
