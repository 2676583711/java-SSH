package cn.zhou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * 本项目采用全注解版本
 * 
 * 包括mybatis，都是注解没有xml配置文件 
 */
@MapperScan("cn.zhou.dao")
@SpringBootApplication
public class SpringbootShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootShiroApplication.class, args);
	}
}
