package com.ias;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.ias.*.*.mapper")
@SpringBootApplication
public class IasApplication {

	public static void main(String[] args) {
		SpringApplication.run(IasApplication.class, args);
		System.out.println("ヾ(◍°∇°◍)ﾉﾞ    ias启动成功      ヾ(◍°∇°◍)ﾉﾞ\n");

	}
}
