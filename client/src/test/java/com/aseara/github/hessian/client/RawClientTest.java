package com.aseara.github.hessian.client;

import com.aseara.github.hessian.service.HelloService;
import com.aseara.github.hessian.service.HelloService2;
import com.caucho.hessian.client.HessianProxyFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;

/**
 * Created by qiujingde on 2017/3/8.
 * 原生测试
 */
public class RawClientTest {

    private static final Logger LOG = LoggerFactory.getLogger(SpringClientTest.class);

    @Test
    public void hello() throws MalformedURLException {
        String url = "http://localhost:8080/hessian";
        HessianProxyFactory factory = new HessianProxyFactory();
        HelloService helloService = (HelloService) factory.create(HelloService.class, url);
        LOG.debug(helloService.helloWorld("from raw to raw"));
    }

}
