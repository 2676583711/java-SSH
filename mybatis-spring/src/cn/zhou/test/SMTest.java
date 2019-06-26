package cn.zhou.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zhou.dao.UserDao;
import cn.zhou.entity.User;

class SMTest {

	private static ApplicationContext ac;

	// spring-mybatis
	@Test
	public void test1() {
		ac = new ClassPathXmlApplicationContext("classpath:spring/spring1.xml");

		UserDao dao = (UserDao) ac.getBean("userDao");

		List<User> list = dao.find();

		System.out.println(list);

	}

	// public static void main(String[] args) throws IOException {
	// ac = new ClassPathXmlApplicationContext("classpath:spring/spring1.xml");
	//
	// UserDao dao = (UserDao) ac.getBean("userDao");
	//
	// System.out.println(dao);
	//
	// List<User> list = dao.find();
	//
	// System.out.println(list);
	//
	// }

	// mybatis
	@Test
	public void test2() throws IOException {
		String path = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(path);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession ss = ssf.openSession();
		List list = ss.selectList("sm.select1");
		System.out.println(list);
		ss.close();

	}

	@Test
	void t() {
		ac = new ClassPathXmlApplicationContext("classpath:spring/spring1.xml");

		UserDao dao = (UserDao) ac.getBean("userDao");

		SqlSessionFactory ssf = (SqlSessionFactory) ac.getBean("ssf");
		System.out.println("ss......///*****///**" + ssf.openSession());

		System.out.println(ssf.openSession().selectList("sm.select1"));

		System.out.println("*//**/*/*/*/*/*/userdao*/*/*/**//*/*/*");
		System.out.println(dao.find());

	}

}
