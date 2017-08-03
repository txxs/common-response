package com.txxs.common.response.exception;

import org.springframework.http.HttpStatus;

/**
 * @Author:jianghuimin
 * @Date: 2017/8/3
 * @Time:17:00
 */
public final class SpecificHttpStatusException extends UniversalException {
    private String code;
    private HttpStatus httpStatus;

    public SpecificHttpStatusException(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.code = this.parseToCode(httpStatus);
    }

    public SpecificHttpStatusException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.code = this.parseToCode(httpStatus);
    }

    public String getCode() {
        return this.code;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}

