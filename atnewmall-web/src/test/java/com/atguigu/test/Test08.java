package com.atguigu.test;

import java.util.List;

public class Test08 {

	public static void main(String[] args) throws Exception {
		
		Thread t1 = new Thread();
		Thread t2 = new Thread();
		
		t1.start();
		t2.start();
		
		// 成员方法
		// 对象调用的当前线程等待
		t1.wait(1000);
		// 静态方法
		// sleep对当前正在执行的线程休眠
		Thread.sleep(1000);
		
	}
	

}
