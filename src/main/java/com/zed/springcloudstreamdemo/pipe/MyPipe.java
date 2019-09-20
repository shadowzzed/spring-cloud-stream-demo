package com.zed.springcloudstreamdemo.pipe;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author Zeluo
 * @date 2019/9/20 17:06
 */
public interface MyPipe {
//    @Input(Processor.OUTPUT)
//    SubscribableChannel input();

    String INPUT = "out";
    @Input(MyPipe.INPUT)
    SubscribableChannel input();
}
