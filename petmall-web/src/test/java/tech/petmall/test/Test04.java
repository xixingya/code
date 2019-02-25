package tech.petmall.test;

import java.lang.reflect.Field;

public class Test04 {

	public static void main(String[] args) throws Exception {
		int i = getResult();
		
		System.out.println("i =" + i );
		
		//int i = 0;
		// 临时变量
		//i = i++; // _a = (i++); i = _a
		//System.out.println("i = " + i);
	}
	
	public static int getResult() {
		
		// 每一个方法都会有临时变量 _rtnVal
		// 只要使用return关键字，那么就会使用_rtnVal
		
		// finally
		
		int i = 0;
		
		try {
			return i++; // 1) _rtnVal = 0; i = 1; 2) 判断是否存在finally子句
		} finally {
			//return ++i; // 3) _rtnVal = 2; i = 2; 4) return _rtnVal
			++i;
		}
	}
}