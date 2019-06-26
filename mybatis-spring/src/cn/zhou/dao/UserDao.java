package cn.zhou.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.zhou.entity.User;

public interface UserDao {
	
	public  List<User> find();

}
