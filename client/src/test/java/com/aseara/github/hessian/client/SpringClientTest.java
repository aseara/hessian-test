package com.aseara.github.hessian.client;

import com.aseara.github.hessian.service.HelloService;
import com.caucho.hessian.client.HessianProxyFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.MalformedURLException;

/**
 * Created by qiujingde on 2017/3/8.
 * spring + hessian client
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/hessian-client.xml")
public class SpringClientTest {

    private static final Logger LOG = LoggerFactory.getLogger(SpringClientTest.class);

    @Qualifier("hessianClient1")
    @Autowired
    private HelloService client1;

    @Qualifier("hessianClient2")
    @Autowired
    private HelloService client2;

    @Test
    public void rawHello() throws MalformedURLException {
        String url = "http://localhost:8080/hessian";
        HessianProxyFactory factory = new HessianProxyFactory();
        HelloService helloService = (HelloService) factory.create(HelloService.class, url);
        LOG.debug(helloService.helloWorld("from raw to raw"));

        url = "http://localhost:8080/service";
        helloService = (HelloService) factory.create(HelloService.class, url);
        LOG.debug(helloService.helloWorld("from spring to raw"));
    }

    @Test
    public void hello() {
        LOG.debug(client1.helloWorld("from raw to spring"));
        LOG.debug(client2.helloWorld("from spring to spring"));
    }

}
