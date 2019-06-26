package cn.zhou.dao;

import java.util.List;

import cn.zhou.entity.BaoUser;
import cn.zhou.entity.User;

public interface UserMapper {

	// <mapper namespace="test1">
	// <select id="find1" parameterType="int"

	// resultType="cn.zhou.entity.User">

	// select *from m_user where id=#{abc}
	// </select>
	//

	// public User find1(int id,String username) throws Exception;
	//public User find1(BaoUser u) throws Exception;

	public List<User> find1(BaoUser u) throws Exception;

	// 使用resultMap查询
	public User findByResultMap(int id) throws Exception;

}
