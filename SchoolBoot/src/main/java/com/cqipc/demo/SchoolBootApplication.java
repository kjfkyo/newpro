package com.cqipc.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages ="com.cqipc.demo.dao")
@SpringBootApplication
public class SchoolBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolBootApplication.class, args);
	}

}
