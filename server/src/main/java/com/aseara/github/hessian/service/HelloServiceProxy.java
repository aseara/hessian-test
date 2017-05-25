package com.aseara.github.hessian.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by aseara on 2017/3/28.
 *
 */
@Service
public class HelloServiceProxy implements HelloService {
    private HelloService service = new HelloServiceImpl();

    @Override
    public String helloWorld(String message) {
        return service.helloWorld(message);
    }
}
