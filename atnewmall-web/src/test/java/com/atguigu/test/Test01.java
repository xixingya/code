package com.atguigu.test;

public class Test01 {

	public static void main(String[] args) throws Exception {
		B b = new C();
		test(b);
	}

	public static void test( B b ) {
		System.out.println("bbbb");
	}
	
	public static void test( C c ) {
		System.out.println("ccccc");
	}
}
class B {

}
class C extends B {
	
}