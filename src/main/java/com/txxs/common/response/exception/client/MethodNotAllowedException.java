package com.txxs.common.response.exception.client;

import com.txxs.common.response.exception.ClientException;
import com.txxs.common.response.exception.UniversalException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author:jianghuimin
 * @Date: 2017/8/3
 * @Time:17:23
 */
@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
@UniversalException.Code("E000000405")
public class MethodNotAllowedException extends ClientException {
    public MethodNotAllowedException() {
    }

    public MethodNotAllowedException(String message) {
        super(message);
    }

    public MethodNotAllowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MethodNotAllowedException(Throwable cause) {
        super(cause);
    }

    public MethodNotAllowedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

