package com.txxs.common.response.controller;

import com.txxs.common.response.exception.server.BadGatewayException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:jianghuimin
 * @Date: 2017/8/3
 * @Time:17:37
 */
@RestController
public class Test {

    @RequestMapping(path = "/name",method = RequestMethod.GET )
    public void doNothing(){
        throw new BadGatewayException("ewew");
    }
}
