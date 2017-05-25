package com.aseara.github.hessian.service;

import org.springframework.stereotype.Service;

/**
 * Created by qiujingde on 2017/3/8.
 * 服务实现
 */
public class HelloServiceImpl implements HelloService {

    public String helloWorld(String message) {
        return "hello, " + message;
    }

}
