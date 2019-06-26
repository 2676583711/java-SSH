package cn.zhou.entity;


//实现序列化接口，因为二级缓存的数据，有可能不仅仅只是存在于内存中，
//（也可以存在于硬盘中）这个时候就需要实现序列化接口
import java.io.Serializable;

import java.util.Date;

public class User  implements Serializable{
	private Integer id;
	private String username;
	private String password;
	private Date birthday;

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", birthday=" + birthday + "]";
	}

}
