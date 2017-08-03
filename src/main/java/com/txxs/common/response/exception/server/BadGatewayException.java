package com.txxs.common.response.exception.server;

import com.txxs.common.response.exception.ServerException;
import com.txxs.common.response.exception.UniversalException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author:jianghuimin
 * @Date: 2017/8/3
 * @Time:17:23
 */
@ResponseStatus(HttpStatus.BAD_GATEWAY)
@UniversalException.Code("E000000502")
public class BadGatewayException extends ServerException {
    public BadGatewayException() {
    }

    public BadGatewayException(String message) {
        super(message);
    }

    public BadGatewayException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadGatewayException(Throwable cause) {
        super(cause);
    }

    public BadGatewayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

