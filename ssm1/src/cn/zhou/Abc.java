package cn.zhou;

import org.junit.Test;

public class Abc implements A{

	public static void main(String[] args) {

		a1: for (int i = 1; i <= 4; i++) {

			for (int j = 0; j <= 10; j++) {
				int a = j / 4;

				int b = j % 4;

				if (b == 01) {
					continue a1;
				}

				// System.out.print(a+"\t");

				System.out.print(b + "\t");

			}
			System.out.println();

		}
		// System.out.println();

	}
	
	
	@Test
	public void test1() {
		System.out.println(5.7*100);
		System.out.println(5.7*10*10);
		
	}

}
