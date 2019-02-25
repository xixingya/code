package tech.petmall.test;

public class Test02 {

	public static void main(String[] args) throws Exception {
		BB bb = new CC();
		// 动态绑定机制（只针对于成员方法，和属性没关系）
		// 当程序运行时，调用了对象的成员方法，那么JVM会将方法和当前对象的实际内存进行绑定，然后调用
		System.out.println(bb.getSum());
	}
}
class BB {
    public int i = 10;
    
    public int getSum() {
    	return getI()+10;
    }
    
    public int getI() {
    	return i;
    }
}
class CC extends BB {
    public int i = 20;
    
//    public int getSum() {
//    	return i+20;
//    }
    
    public int getI() {
    	return i;
    }
}