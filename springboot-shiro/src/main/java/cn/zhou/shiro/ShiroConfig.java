package cn.zhou.shiro;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

	/*
	 * 用户主体：subject(ShiroFilterFactoryBean)
	 */

	@Bean // 必须声明这个bean交由spring管理
	public ShiroFilterFactoryBean getFactoryBean(
			@Qualifier("seurityManager") DefaultWebSecurityManager securityManager) {

		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		// shiro内置过滤器，实现认证相关操作:
		// **** 常用过滤器:
		// -----------anon:无需认证即可访问
		// authc:必须认证才可以访问
		// user: 使用rememberMe的功能才能访问
		// perms:该资源必须得到资源权限才能访问
		// role:必须得到角色权限才能访问
		Map<String, String> map = new HashMap<String, String>();

		// 注意：这个过滤器的执行顺序，从上到下先定义先执行

		map.put("/login", "anon"); // 设置/login无需认证就能访问
		map.put("/manage", "anon");

		map.put("/find", "perms[abc]");// 设置资源访问权限

		// map.put("/*", "authc"); // 根目录下面所有的资源度需要认证才能访问

		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);//
		// 这里Map集合，key是资源路径，value是过滤器名字，如:anon

		shiroFilterFactoryBean.setLoginUrl("/manage");
		shiroFilterFactoryBean.setUnauthorizedUrl("/unauthc");

		return shiroFilterFactoryBean;

	}

	/*
	 * DeafaultWebSecurityManager
	 *
	 * @Qualifier("realm") UserRealm realm
	 */

	@Bean(name = "seurityManager")
	public DefaultWebSecurityManager getSecurityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

		// securityManager.setRealm(getRealm());
		securityManager.setRealm(getRealm());

		return securityManager;
	}

	/*
	 * realm
	 */
	@Bean(name = "realm")
	public UserRealm getRealm() {
		return new UserRealm();
	}
}
