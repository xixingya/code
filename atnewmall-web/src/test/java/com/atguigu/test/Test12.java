package com.atguigu.test;

import java.util.HashMap;
import java.util.Map;

public class Test12 {

	public static void main(String[] args) throws Exception {
		// 16 ==> 32 ==> 64
		// 8 => 9 => 10 => 11
		Map<Emp, Emp> empMap = new HashMap<Emp, Emp>();
		for ( int i = 1; i <= 20; i++ ) {
			Emp emp = new Emp();
			empMap.put(emp, emp);
			System.out.println("**********");
		}
		
	}
	

}
