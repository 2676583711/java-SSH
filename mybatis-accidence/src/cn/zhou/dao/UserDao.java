package cn.zhou.dao;

import java.util.List;

import cn.zhou.entity.BaoUser;
import cn.zhou.entity.User;

public interface UserDao {
	
	public List<User> find1(BaoUser u) throws Exception;

	// 使用resultMap查询
	public User findByResultMap(int id) throws Exception;

}
