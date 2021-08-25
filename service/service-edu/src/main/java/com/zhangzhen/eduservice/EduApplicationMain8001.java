package com.zhangzhen.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.zhangzhen"})
public class EduApplicationMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(EduApplicationMain8001.class,args);
    }
}
