package com.txxs.common.response.builder;

/**
 * @Author:jianghuimin
 * @Date: 2017/8/18
 * @Time:16:19
 */
import java.net.URI;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;

public class JsonResponseEntityBuilder {
    private static final HttpHeaders APPLICATION_JSON_UTF8_HEADER = new HttpHeaders();

    public JsonResponseEntityBuilder() {
    }

    public static <T> ResponseEntity<T> ok(T entity) {
        return ((BodyBuilder)ResponseEntity.ok().headers(APPLICATION_JSON_UTF8_HEADER)).body(entity);
    }

    public static ResponseEntity created() {
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<T> created(T entity, URI uri) {
        BodyBuilder bodyBuilder;
        if(uri == null) {
            bodyBuilder = ResponseEntity.status(HttpStatus.CREATED);
        } else {
            bodyBuilder = ResponseEntity.created(uri);
        }

        return ((BodyBuilder)bodyBuilder.headers(APPLICATION_JSON_UTF8_HEADER)).body(entity);
    }

    public static <T> ResponseEntity<T> accepted(T entity) {
        return ((BodyBuilder)ResponseEntity.accepted().headers(APPLICATION_JSON_UTF8_HEADER)).body(entity);
    }

    public static ResponseEntity noContent() {
        return ResponseEntity.noContent().headers(APPLICATION_JSON_UTF8_HEADER).build();
    }

    static {
        APPLICATION_JSON_UTF8_HEADER.setContentType(MediaType.APPLICATION_JSON_UTF8);
    }
}

