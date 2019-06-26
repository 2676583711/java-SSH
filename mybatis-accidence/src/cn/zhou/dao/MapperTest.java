package cn.zhou.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.zhou.entity.BaoUser;
import cn.zhou.entity.User;

public class MapperTest {

	@Test
	public void test1() throws Exception {

		// 加载配置文件
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().
				build(Resources.getResourceAsStream("sqlMapConfig.xml"));

		// 得到sqlsession
		SqlSession ss = ssf.openSession();

		// 由mabatis创建mapper接口实现类
		UserMapper um = ss.getMapper(UserMapper.class);

		// 根据的得到的接口实现类调用方法
		// User u = um.find1(4, "tom1");

		BaoUser u2 = new BaoUser();

		// u2.getUser().setId(4);
		// u2.getUser().setUsername("tom1");
		List id = new ArrayList();
		id.add(1);
		id.add(2);

		u2.setId(id);

		// User u3 = um.find1(u2);
		List<User> u3 = um.find1(u2);

		System.out.println(u3);
	}

	// 使用resultMap查询
	@Test
	public void test2() throws Exception {
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));
		SqlSession ss = ssf.openSession();
		UserMapper um = ss.getMapper(UserMapper.class);
		User u = um.findByResultMap(4);
		System.out.println(u);
	}

	@Test
	public void test3() throws Exception {
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("sqlMapConfig.xml"));

		SqlSession ss = ssf.openSession();

		UserDao ud = ss.getMapper(UserDao.class);

		User u = ud.findByResultMap(4);
		System.out.println(u);

	}
}
