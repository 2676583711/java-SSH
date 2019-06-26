package cn.zhou.dao;

import java.util.List;

import cn.zhou.pojo.User;

//本来这里需要@Mapper注解的，但由于启动类中已经使用@MapperScan包级别的扫描注解，所以不需要了

//@Repository("userDao")
public interface UserDao {

	public List<User> find();

	public User findByUserName(String username);
}
