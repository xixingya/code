package tech.petmall.test;

import java.lang.reflect.Field;

public class Test03 {

	public static void main(String[] args) throws Exception {
		
		// 不可变字符串
		// trim方法只能去掉半角空格
		String s = " a b ";
		
//		Class c = String.class;
//		Field f = c.getDeclaredField("value");
//		f.setAccessible(true);
//		char[] cs = (char[])f.get(s);
//		cs[2] = '1';
		
		s = s.trim();
		System.out.println( "!"+s+"!" );
		
	}
}