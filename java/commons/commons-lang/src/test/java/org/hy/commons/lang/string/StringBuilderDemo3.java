package org.hy.commons.lang.string;

/**
 *			AAA
			AAA
			111
			111
			----------------------
			BBB
			AAACCC
			222
			111
			----------------------
			AAA
			AAACCC
			111
			111
 */
/*
 * String ,StringBuffer,StringBuilder都是复合数据类型
 * String ,StringBuffer,StringBuilder对应的变量（比如，xxx），存放的数据，
 * 都是xxx所指向的String常量的引用或者指向StringBuffer,StringBuilder对象的引用。
 * 所以，不管基础数据类型，还发复合数据类型，无论是方法中的传递参数，还是用‘=’赋值，传递的都是，该变量，所在内存空间中的数值，
 * 础数据类型，和复合数据类型，的变量的唯一区别，就是，前者变量空间中，存放的是，八种基本数据类型的数值；后者的变量空间中，存放的是，对应的对象或者常量的引用。
 * 可以，把础数据类型，和复合数据类型，的变量的赋值，都看成，数值的传递，一个是真实数据，一个是引用的值的传递。
 * 
 * 可以在引申，到c语言中的，&xxx，和xxx。
 * 
 * 还有，千万注意：
 * 复合数据类型的对象的变量，在方法中的传递：这个变量不要，再用‘=’赋值。否则，容易出现，下面例子中的sb1的问题
 */
public class StringBuilderDemo3 {
	static String s1_1 ="111";
	public static void main(String[] args) {

		StringBuilder sb1 = new StringBuilder("AAA");
		StringBuilder sb2 = new StringBuilder("AAA");

		String s1 = "111";
		String s2 = "111";
		String s3 = "111";

		
		System.out.println(sb1);//AAA
		System.out.println(sb2);//AAA
		System.out.println(s1);//111
		System.out.println(s2);//111
		System.out.println(sb1+"sb1的地址是"+sb1.hashCode());//111
		System.out.println(sb2+"sb2的地址是"+sb2.hashCode());//111
		System.out.println("sb1==sb2是"+(sb2==sb1));//true



		System.out.println(s1+"s1的地址是"+s1.hashCode());//111
		System.out.println(s1_1+"s1_1的地址是"+s1_1.hashCode());//111
		System.out.println("s1==s2是"+(s2==s1));//true
		System.out.println("s1==s1_1是"+(s1_1==s1));//true
		
		System.out.println("----------------------");
		
		replace(sb1, sb2, s1, s2);
		
		System.out.println("----------------------");
		
		/*
		 * 这个最重要
		 */
		System.out.println(sb1);//AAA
		System.out.println(sb2);//AAACCC 
		System.out.println(s1);//111
		System.out.println(s2);//111  
	}


	public static void replace(StringBuilder sb1,StringBuilder sb2,String s1,String s2){
		System.out.println("s1==s_1是"+(s1_1==s1));//111
		System.out.println("-->"+s1);
		System.out.println("-->"+s2);
		
		System.out.println("sb1" + sb1);
		System.out.println("sb2" + sb2);
		sb1 = new StringBuilder("BBB");
		sb2.append("CCC");
		s1  = new String("222");
		
		String  ret = s2.concat("333");//111333
	
		System.out.println(sb1);//BBB   
		System.out.println(sb2);//AAACCC
		System.out.println(s1);//222
		System.out.println(s2);//111 
	}
}
