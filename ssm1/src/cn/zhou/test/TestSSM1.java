package cn.zhou.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zhou.dao.UserDao;
import cn.zhou.entity.User;

public class TestSSM1 {

	/*
	 * 根据姓名查找
	 */
	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

		UserDao ud = (UserDao) ac.getBean("mapper1");

		List<User> u = ud.findUserByName("sad");
		// List<User> u = ud.findUserById(4);

		System.out.println(u);

	}

	/*
	 * 插入数据
	 */
	@Test
	public void test2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

		UserDao ud = (UserDao) ac.getBean("mapper1");

		User u = new User();
		u.setUsername("赵子龙");
		u.setPassword("wagnwu ");

		ud.insert(u);

		// User u2 = new User();
		// u.setUsername("赵柳");
		// u.setPassword("zhaoliu ");
		//
		// ud.insert(u2);

	}

	/*
	 * 插入数据
	 */
	@Test
	public void test5() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

		UserDao ud = (UserDao) ac.getBean("mapper1");

		List<User> list = new ArrayList<User>();
		User u = new User();
		u.setUsername("赵子龙");
		u.setPassword("wagnwu ");

		User u2 = new User();
		u.setUsername("赵柳");
		u.setPassword("zhaoliu ");

		list.add(u);
		list.add(u2);

		ud.insertList(list);

	}

	/*
	 * 删除数据
	 *
	 */

	@Test
	public void test3() {

		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud = (UserDao) ac.getBean("mapper1");
		ud.deleteById(11);

	}

	/*
	 * 使用数组，执行批量删除
	 */
	@Test
	public void test4() {

		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		UserDao ud = (UserDao) ac.getBean("mapper1");
		int a[] = { 1, 2, 3, 4, 5, 6 };
		ud.deleteByIdArray(a);

	}

	@Test
	public void abc() {
		Scanner s = new Scanner(System.in);
		System.out.println("please input your string:");

		String line = s.nextLine();

		String result = "";
		char[] c = line.toCharArray();

		for (int a = c.length - 1; a >= 0; a--) {
			result += c[a];
		}

		System.out.println(result);

		System.out.println("please input int value:");

		int i = s.nextInt();
		System.out.println(i);

		s.close();
	}

}
