package com.txxs.common.response.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @Author:jianghuimin
 * @Date: 2017/8/3
 * @Time:16:58
 */
public class ExceptionResponseEntity extends ResponseEntity<ExceptionResponseEntity.OutputJson> {
    private ExceptionResponseEntity(ExceptionResponseEntity.OutputJson body, HttpStatus httpStatus) {
        super(body, httpStatus);
    }

    public static ExceptionResponseEntity response(Exception e, HttpStatus httpStatus) {
        return new ExceptionResponseEntity(ExceptionResponseEntity.OutputJson.create(e), httpStatus);
    }

    public static class OutputJson {
        private String code;
        private String message;
        private Object detail;

        public OutputJson() {
        }

        public static ExceptionResponseEntity.OutputJson create(Exception e) {
            if(e instanceof UniversalException) {
                return create((UniversalException)e);
            } else {
                ExceptionResponseEntity.OutputJson oj = new ExceptionResponseEntity.OutputJson();
                oj.code = "E000000000";
                oj.message = e.getMessage();
                oj.detail = null;
                return oj;
            }
        }

        static ExceptionResponseEntity.OutputJson create(UniversalException e) {
            ExceptionResponseEntity.OutputJson oj = new ExceptionResponseEntity.OutputJson();
            oj.code = e.getCode();
            oj.message = e.getMessage();
            oj.detail = e.getDetail();
            return oj;
        }

        public String getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public Object getDetail() {
            return this.detail;
        }
    }
}
