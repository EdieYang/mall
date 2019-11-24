package com.linkpets;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.linkpets.dao")
public class LinkpetsMallApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkpetsMallApiApplication.class, args);
    }

}
