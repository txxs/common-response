package com.txxs.common.response.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author:jianghuimin
 * @Date: 2017/8/3
 * @Time:17:05
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
@UniversalException.Code("E000000500")
public class ServerException extends UniversalException {
    public ServerException() {
    }

    public ServerException(String message) {
        super(message);
    }

    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerException(Throwable cause) {
        super(cause);
    }

    public ServerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

