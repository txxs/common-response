package com.txxs.common.response.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author:jianghuimin
 * @Date: 2017/8/3
 * @Time:16:56
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
@UniversalException.Code("E000000400")
public class ClientException extends UniversalException {
    public ClientException() {
    }

    public ClientException(String message) {
        super(message);
    }

    public ClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientException(Throwable cause) {
        super(cause);
    }

    public ClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

