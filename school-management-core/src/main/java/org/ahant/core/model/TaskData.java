package org.ahant.core.model;

import org.ahant.core.exception.ResultException;

/**
 * Created by ahant on 7/27/2016.
 */
public class TaskData<T extends Input> {
    private T source;
    private Result target;
    private ResultException exception;

    public T getSource() {
        return source;
    }

    public void setSource(T source) {
        this.source = source;
    }

    public Result getTarget() {
        return target;
    }

    public void setTarget(Result target) {
        this.target = target;
    }

    public ResultException getException() {
        return exception;
    }

    public void setException(ResultException exception) {
        this.exception = exception;
    }
}
