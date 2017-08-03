package com.txxs.common.response.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Author:jianghuimin
 * @Date: 2017/8/3
 * @Time:16:53
 */
@ControllerAdvice
public class ExceptionHandlerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ExceptionHandlerController() {
    }

    @ExceptionHandler({Exception.class})
    public ExceptionResponseEntity exceptionHandler(Exception e) {
        this.logger.error(e.getMessage(), e);
        ResponseStatus responseStatus = (ResponseStatus) AnnotatedElementUtils.findMergedAnnotation(e.getClass(), ResponseStatus.class);
        HttpStatus httpStatus = responseStatus == null?HttpStatus.INTERNAL_SERVER_ERROR:responseStatus.code();
        return ExceptionResponseEntity.response(e, httpStatus);
    }

    @ExceptionHandler({SpecificHttpStatusException.class})
    public ExceptionResponseEntity specificHttpStatusExceptionHandler(SpecificHttpStatusException e) {
        this.logger.error(e.getMessage(), e);
        return ExceptionResponseEntity.response(e, e.getHttpStatus());
    }

    @ExceptionHandler({ServerException.class})
    public ExceptionResponseEntity serverExceptionHandler(ServerException e) {
        this.logger.error(e.getMessage(), e);
        ResponseStatus responseStatus = (ResponseStatus)AnnotatedElementUtils.findMergedAnnotation(e.getClass(), ResponseStatus.class);
        return ExceptionResponseEntity.response(e, responseStatus.code());
    }

    @ExceptionHandler({ClientException.class})
    public ExceptionResponseEntity clientExceptionHandler(ClientException e) {
        this.logger.error(e.getMessage(), e);
        ResponseStatus responseStatus = (ResponseStatus)AnnotatedElementUtils.findMergedAnnotation(e.getClass(), ResponseStatus.class);
        return ExceptionResponseEntity.response(e, responseStatus.code());
    }
}

