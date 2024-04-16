package com.xiong.cloud;

import com.xiong.cloud.demo02.T1;
import com.xiong.cloud.demo02.T2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages ="com.xiong.cloud")
public class DemoApplication {

    public static void main(String[] args) {
        new T1().start();
        new T2().start();
        SpringApplication.run(DemoApplication.class, args);
    }

}
