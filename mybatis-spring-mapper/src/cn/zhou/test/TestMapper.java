package cn.zhou.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zhou.dao.UserMapper;
import cn.zhou.entity.User;

class TestMapper {
	/*
	 * spring与mybatis整合 使用mybatis的mapper代理的方法
	 */
	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring1.xml");
		UserMapper m = (UserMapper) ac.getBean("mapper");

		// List<User> list = m.find();

		List<User> list = m.find();

		// System.out.println(ac.getBean("c3p0"));
		System.out.println(list);
	}

	/*
	 * 使用扫描器，进行批量扫描 批量注册mapper代理
	 */
	@Test
	public void test2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring2.xml");
		UserMapper m = (UserMapper) ac.getBean("userMapper");

		List<User> list = m.find();
		// System.out.println(ac.getBean("ssf"));
		
		System.out.println(list);
	}

}
