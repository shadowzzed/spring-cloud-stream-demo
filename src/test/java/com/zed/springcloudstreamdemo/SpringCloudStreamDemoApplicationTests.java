package com.zed.springcloudstreamdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
@EnableBinding(Processor.class)
public class SpringCloudStreamDemoApplicationTests {

    @Autowired
    Processor source;

    @Test
    public void contextLoads() throws InterruptedException {
        source.output().send(MessageBuilder.withPayload("aaa").build());
//        Thread.sleep(1000);
    }

}
