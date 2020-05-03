package com.radio.videogamescriticism;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//启动类中添加对 mapper 包扫描
@MapperScan("com.radio.videogamescriticism.repository")
public class VgcApplication {

    public static void main(String[] args) {
        SpringApplication.run(VgcApplication.class, args);
    }

}
