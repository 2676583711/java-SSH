package cn.zhou.test;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class FirstTestRedis {

	/*
	 * 单实例
	 */
	@Test
	public void test1() {
		Jedis jedis = new Jedis("localhost", 6379);

		jedis.set("jedis", "jedis.value12222");

		System.out.println(jedis.get("jedis"));

	}

	/*
	 * jedisPool
	 * 
	 * 连接池
	 */

	@Test
	public void test2() {
		JedisPoolConfig jpc = new JedisPoolConfig();

		jpc.setMaxTotal(30);

		jpc.setMaxIdle(10);

		JedisPool jp = new JedisPool(jpc, "127.0.0.1", 6379);

		Jedis jedis = jp.getResource();

		jedis.set("jedispool", "jedis.pool.value.110");

		System.out.println(jedis.get("jedispool"));
	}
}
