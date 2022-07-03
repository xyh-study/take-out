package com.njpi.xyh.takeout.exception;

/**
 * @author: xyh
 * @create: 2022/7/3 15:45
 */
public class InsertFailException  extends RuntimeException{
    public InsertFailException() {
    }

    public InsertFailException(String message) {
        super(message);
    }

    public InsertFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertFailException(Throwable cause) {
        super(cause);
    }

    public InsertFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
