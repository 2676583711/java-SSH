package cn.zhou.dao;

import java.util.List;
/*
 * 注入sqlsession有两种方法
 * 1.继承  SqlSessionDaoSupport，（ extends SqlSessionDaoSupport）
 * 2. 使用sqlSessionTemplate类注入sqlsession

 */

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zhou.entity.User;

public class UserDaoImpl implements UserDao {

	// 使用 sqlsessionTemplate注入sqlsession
	private SqlSession ss;
	public void setSs(SqlSession ss) {
		this.ss = ss;
	}

	public List<User> find() {
		// SqlSession ss = this.getSqlSession();

		List<User> list = ss.selectList("sm.select1");
		// ss.close();
		return list;
	}

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring1.xml");
		// UserDao dao = (UserDaoImpl) ac.getBean("userDao");
		// List l = dao.find();
		System.out.println(ac.getBean("ssf"));

	}
}
