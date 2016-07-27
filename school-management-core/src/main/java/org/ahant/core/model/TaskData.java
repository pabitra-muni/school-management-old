package org.ahant.core.model;

import org.ahant.core.exception.ResultException;

/**
 * Created by ahant on 7/27/2016.
 */
public class TaskData {
    private Object source;
    private Result target;
    private ResultException exception;

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
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
