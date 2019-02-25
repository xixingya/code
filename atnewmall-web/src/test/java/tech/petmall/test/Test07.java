package tech.petmall.test;

import java.util.List;

public class Test07 {

	public static void main(String[] args) throws Exception {
		//AA aa = null;
		// 调用为空（null）对象的成员属性或方法会出现空指针异常
		//aa.print();
		// 自动拆箱时，如果包装类为null，也会出现空指针异常
		//Integer i = null;
		//int i1 = i;
		
		//wait
		//sleep
		
		// 
		List<Integer> is = null;
		for ( Integer i2 : is ) {
			System.out.println( i2 );
		}
		
		//print(i);
	}
	
	public static void print(int i) {
		System.out.println(i);
	}
}
class AA {
	public static void print() {
		
	}
}