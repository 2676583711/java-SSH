package cn.zhou.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import cn.zhou.entity.User;

public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void add(String username, String password) {

		// Configuration configuration = new Configuration().configure();
		// SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction t = session.beginTransaction();

		User user = new User();

		user.setUsername(username);
		user.setPassword(password);

		// session.save(user);

		session.persist(user);

		t.commit();

		// 关闭资源
		session.close();
		sessionFactory.close();
	}

	public User find(int id) {
		Session session = sessionFactory.openSession();
		// session.find(User.class, id);
		User user = session.get(User.class, id);
		return user;

	}

}
