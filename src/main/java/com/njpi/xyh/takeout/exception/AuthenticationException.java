package com.njpi.xyh.takeout.exception;

import com.njpi.xyh.takeout.result.Result;
import lombok.Data;

import javax.annotation.Resource;

/**
 * 自定义认证异常
 *
 * @author: xyh
 * @create: 2022/7/2 19:51
 */
@Data
public class AuthenticationException extends RuntimeException {

    @Resource
    private Result result;

    public AuthenticationException() {
    }

    public AuthenticationException(Result result) {
        this.result = result;
    }

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationException(Throwable cause) {
        super(cause);
    }

    public AuthenticationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
