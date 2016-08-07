package org.ahant.core.controller;

import org.ahant.core.model.Input;
import org.ahant.core.model.Result;
import org.ahant.core.model.TaskData;

/**
 * Created by ahant on 7/27/2016.
 */
public class SimpleTaskExecutor<T extends Input> implements TaskExecutor<T> {

    DataValidator<T> validator;
    DataProcessor<T> processor;
    ResultBuilder<T> resultBuilder;

    @Override
    public boolean validate(TaskData<T> taskData) {
        return validator.validate(taskData);
    }

    @Override
    public void process(TaskData<T> taskData) {
        processor.process(taskData);
    }

    @Override
    public Result buildResult(TaskData<T> taskData) {
        return resultBuilder.buildResult(taskData);
    }

    public ResultBuilder<T> getResultBuilder() {
        return resultBuilder;
    }

    public void setResultBuilder(ResultBuilder<T> resultBuilder) {
        this.resultBuilder = resultBuilder;
    }

    public DataValidator<T> getValidator() {
        return validator;
    }

    public void setValidator(DataValidator<T> validator) {
        this.validator = validator;
    }

    public DataProcessor<T> getProcessor() {
        return processor;
    }

    public void setProcessor(DataProcessor<T> processor) {
        this.processor = processor;
    }
}
