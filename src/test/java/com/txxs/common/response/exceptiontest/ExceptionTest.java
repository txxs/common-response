package com.txxs.common.response.exceptiontest;

import com.txxs.common.response.exception.server.BadGatewayException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:jianghuimin
 * @Date: 2017/8/3
 * @Time:17:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExceptionTest {

    @Test
    public void throwException(){
        throw new BadGatewayException("we");
    }
}
