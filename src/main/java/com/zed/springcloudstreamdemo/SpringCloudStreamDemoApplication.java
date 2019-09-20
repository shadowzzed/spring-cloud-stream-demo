package com.zed.springcloudstreamdemo;

import com.zed.springcloudstreamdemo.pipe.MyPipe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding({
//        Sink.class,
        MyPipe.class,
        Processor.class
})// 目的地绑定 本身包含@Configuration
public class SpringCloudStreamDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamDemoApplication.class, args);
    }

//    @StreamListener(Sink.INPUT)
//    public void receive(Object payload) {
//        System.out.println(payload);
//    }

    @StreamListener(Processor.INPUT) // 监听名称为input的信道
    @SendTo(MyPipe.INPUT) // 发送至名称为out的信道上
    public String handle1(String value) {
        System.out.println("Received "+ value);
        return value.toUpperCase();
    }

    @StreamListener(MyPipe.INPUT) // 监听信道，名称为out
    public void handle(String value) {
        System.out.println("Received " + value);
    }

//    @Bean
//    public Consumer<Person> log() {
//        return person -> System.out.println("Received" + person);
//    }
//    @Data
//    private static class Person {
//        private String name;
//
//    }
}

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//import java.util.function.Consumer;
//
//@SpringBootApplication
//public class SpringCloudStreamDemoApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(SpringCloudStreamDemoApplication.class, args);
//    }
//
//    @Bean
//    public Consumer<Person> log() {
//        return person -> {
//            System.out.println("Received: " + person);
//        };
//    }
//
//    public static class Person {
//        private String name;
//        public String getName() {
//            return name;
//        }
//        public void setName(String name) {
//            this.name = name;
//        }
//        public String toString() {
//            return this.name;
//        }
//    }
//}