package tech.petmall.petmall.common.util;

public class StringUtil {

	public static boolean isEmpty( String s ) {
		return s == null || "".equals(s.trim());
	}
}
