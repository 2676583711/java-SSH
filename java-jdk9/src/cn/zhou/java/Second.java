package cn.zhou.java;

import cn.zhou.java02.B;

public class Second {

	/*
	 * 方法引用的测试
	 */

	public static void main(String[] args) {

		B b = (int x) -> {
			// return -x;
			System.out.println("-x:" + -x);
			return x;
		};

		System.out.println(b.getAbs(-100));
		System.out.println("//////////////////");

		B bc = Math::abs;
		System.out.println(bc.getAbs(-123));
		System.out.println("*****************");

		String s = "546";
		Integer i = new Integer(s);
		
		Integer is = Integer.parseInt(s);

		System.out.println(s.equals("46"));

	}
}
