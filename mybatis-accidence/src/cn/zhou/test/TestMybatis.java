package cn.zhou.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import cn.zhou.entity.User;

public class TestMybatis {

	// 给出映射文件的路径
	private static String resource = "sqlMapConfig.xml";

	public static void main(String[] args) throws IOException {
		// 使用一个输入流得到文件
				InputStream inputStream = Resources.getResourceAsStream(resource);
				// 创建会话工厂
				SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);

				// 得到session对象
				SqlSession ss = ssf.openSession();

				User user = ss.selectOne("test1.find1", 1);
				System.out.println(user);

				ss.close();
	}

	@Test
	public void test1() throws IOException {

		// 使用一个输入流得到文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建会话工厂
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);

		// 得到session对象
		SqlSession ss = ssf.openSession();

		User user = ss.selectOne("test1.find1", 1);
		System.out.println(user);

		ss.close();

	}

	@Test
	public void test2() throws IOException {

		InputStream inputStream = Resources.getResourceAsStream(resource);

		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession ss = ssf.openSession();
		List<User> list = ss.selectList("test1.find2", "tom");
		System.out.println(list);

		ss.close();
	}

	@Test
	public void test3() throws IOException {

		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession ss = ssf.openSession();
		User u = new User();
		u.setId(4);
		u.setUsername("张晓明");
		u.setPassword("110");
		u.setBirthday(new Date());
		ss.insert("test1.insert1", u);

		ss.commit();

		ss.close();
	}

	// 使用update方法创建数据表
	@Test
	public void updateCreate() throws IOException {

		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);

		SqlSession ss = ssf.openSession();

		ss.update("test1.update1");
		ss.commit();
	}

	public static SqlSession getSession() {
		InputStream is = null;

		try {
			is = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = ssf.openSession();

		return session;
	}

	// 更新操作
	@Test
	public void test4() throws IOException {
		SqlSession ss = getSession();

		User u = new User();
		u.setId(4);
		u.setUsername("dayima");
		u.setBirthday(new Date());
		u.setPassword("password");

		ss.update("test1.update2", u);

		ss.commit();
		ss.close();

	}

	// 删除操作
	@Test
	public void test5() {

		SqlSession ss = getSession();
		ss.delete("test1.delete1", 3);

		ss.commit();
		ss.close();

	}
}
