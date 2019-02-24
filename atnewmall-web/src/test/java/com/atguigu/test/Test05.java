package com.atguigu.test;

public class Test05 {

	public static void main(String[] args) throws Exception {
		String s = "abc";
		String ss = encode1(s);
		System.out.println("ss = " + ss);
		String sss = decode1(ss);
		System.out.println("sss = " + sss);
	}
	
	public static String encode1( String s ) {
		StringBuilder builder = new StringBuilder();
		for ( char c : s.toCharArray() ) {
			int i = c;
			i = i>>1;
			char cc = (char)i;
			builder.append(cc);
		}
		
		return builder.toString();
	}
	
	public static String decode1( String s ) {
		StringBuilder builder = new StringBuilder();
		for ( char c : s.toCharArray() ) {
			int i = c;
			i = i<<1;
			char cc = (char)i;
			builder.append(cc);
		}
		
		return builder.toString();
	}
	
	public static String encode(String s) {
		StringBuilder builder = new StringBuilder();
		for ( char c : s.toCharArray() ) {
			int i = c;
			i++;
			char cc = (char)i;
			builder.append(cc);
		}
		
		return builder.toString();
	}
	
	public static String decode(String s) {
		StringBuilder builder = new StringBuilder();
		for ( char c : s.toCharArray() ) {
			int i = c;
			i--;
			char cc = (char)i;
			builder.append(cc);
		}
		
		return builder.toString();
	}
}