package cn.zhou.java;

import org.junit.jupiter.api.Test;

import cn.zhou.java02.A;

public class First {

	public static void main(String[] args) {
		// A a = null;
		//
		// int b = a.sum( (1, 3) ->x+y);
		//
		// int b = sum((x, y) -> x + y);
		//
		// System.out.println(b);

		A a = (x, y) -> x + y;

		System.out.println(a.sum(1552, 13));
	}

	static int sum(A a) {

		int i = a.sum(100, 23);
		return i;
	}
	
	
	@Test
	public void test1() {
		
	}

}
