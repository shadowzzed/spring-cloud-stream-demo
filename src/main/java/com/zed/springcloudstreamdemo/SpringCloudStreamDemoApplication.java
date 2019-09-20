package com.zed.springcloudstreamdemo;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
@EnableBinding(Sink.class)
public class SpringCloudStreamDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamDemoApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        System.out.println(payload);
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