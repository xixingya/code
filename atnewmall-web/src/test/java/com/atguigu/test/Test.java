package com.atguigu.test;

public class Test {

	public static void main(String[] args) throws Exception {
		A a = new A();
		// 访问权限：同类，同包，子类
		// 方法的提供者和调用者之间的关系
		// 方法提供者：com.atguigu.test.A //java.lang.Object
		// 方法调用者：com.atguigu.test.Test
		a.clone();
	}

}
class A {

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}