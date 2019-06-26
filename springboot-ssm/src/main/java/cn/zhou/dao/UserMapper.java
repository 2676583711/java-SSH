package cn.zhou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.zhou.pojo.User;


@Mapper
public interface UserMapper {

	public List<User> find();

}
