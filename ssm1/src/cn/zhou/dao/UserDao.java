package cn.zhou.dao;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import cn.zhou.entity.User;

public interface UserDao {

	public List<User> findUserByName(String username);

	public List<User> findUserById(int username);

	public void insert(User u);

	public void insertList(List<User> u);

	public void deleteById(int a);

	public void deleteByIdArray(int[] id);

}
