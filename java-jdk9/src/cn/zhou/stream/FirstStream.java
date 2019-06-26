package cn.zhou.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FirstStream {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("a,123");
		list.add("b,564");

		
		Stream<Integer> s1 = list.stream(). // 把一个list转换成一个流
				map(s -> s.split(",")[1]) // 调用stream的map映射方法(和map集合没有关系)，参数必须是lamda表达式
				.map(s -> new Integer(s)) // 调用map映射方法
				.filter(s -> s >= 100); // 调用filter过滤方法同样参数只能是lamda表达式
		System.out.println(s1);

		System.out.println("/*/*/*/*/*/*/*//**/*/*");

		List<String> list2 = new ArrayList<>();
		list.add("a,123");
		list.add("b,564");
		list2.stream().map(s -> s.split(",")[1]).map(abc -> new Integer(abc)).filter(s -> s >= 100)
				.forEach(System.out::println); // forEach这个方法同样参数必须是lamda表达式，并且不能有返回值，如果有必须自我消费
		;

	}

}
