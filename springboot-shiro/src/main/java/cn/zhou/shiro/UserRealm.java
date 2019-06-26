package cn.zhou.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import cn.zhou.pojo.User;
import cn.zhou.service.UserService;

public class UserRealm extends AuthorizingRealm {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.
	 * shiro.subject.PrincipalCollection)
	 * 
	 * 执行授权逻辑
	 */
	private Boolean info = false;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {

		System.out.println("执行授权逻辑");

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		Subject subject = SecurityUtils.getSubject(); // 得到当前用户

		User user = (User) subject.getPrincipal(); // 从当前用户获取用户的相关信息
		if (user.getUsername().equalsIgnoreCase("abc")) {

			info.addStringPermission("abc"); // 给与资源授权
		}
		return info;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache
	 * .shiro.authc.AuthenticationToken) 执行认证逻辑
	 */
	@Autowired
	private UserService service;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("执行认证逻辑");
		// String name = "zhou";
		// String pass = "123";

		String username = ((UsernamePasswordToken) token).getUsername();

		User u = service.findByUsername(username);

		if (u == null) {
			return null;

		}

		info = true;
		return new SimpleAuthenticationInfo(u, u.getPassword(), "");
	}

}
