package com.txxs.common.response.exception;

import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

/**
 * @Author:jianghuimin
 * @Date: 2017/8/3
 * @Time:16:57
 */
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
@UniversalException.Code("E000000000")
public abstract class UniversalException extends RuntimeException {
    public static final String DEFAULT_CODE = "E000000000";
    private Map<String, Object> detail;

    protected UniversalException() {
    }

    protected UniversalException(String message) {
        super(message);
    }

    protected UniversalException(String message, Throwable cause) {
        super(message, cause);
    }

    protected UniversalException(Throwable cause) {
        super(cause);
    }

    protected UniversalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getCode() {
        UniversalException.Code code = (UniversalException.Code) AnnotatedElementUtils
                .findMergedAnnotation(this.getClass(), UniversalException.Code.class);
        return code.value();
    }

    public String getMessage() {
        String message = super.getMessage();
        if(message == null) {
            message = ((ResponseStatus)AnnotatedElementUtils.findMergedAnnotation(this.getClass(), ResponseStatus.class)).reason();
        }
        return message;
    }

    public Map<String, Object> getDetail() {
        return this.detail;
    }

    public void setDetail(Map<String, Object> detail) {
        this.detail = detail;
    }

    String parseToCode(HttpStatus httpStatus) {
        return "E000000" + httpStatus.value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE})
    public @interface Code {
        String value();
    }
}
