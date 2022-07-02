package com.njpi.xyh.takeout;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: xyh
 * @create: 2022/6/26 13:50
 */
@SpringBootApplication
@MapperScan("com.njpi.xyh.takeout.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
