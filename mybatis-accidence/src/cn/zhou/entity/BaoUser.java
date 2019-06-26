package cn.zhou.entity;

import java.util.List;

public class BaoUser {

	private User user = new User();

	private List id;

	public List getId() {
		return id;
	}

	public void setId(List id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
