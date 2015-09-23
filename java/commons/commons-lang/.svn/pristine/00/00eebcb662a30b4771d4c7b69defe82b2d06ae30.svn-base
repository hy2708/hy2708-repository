package org.hy.commons.lang.string;

public class Strcmp{

    public static void main(String args[]){

           String s1 = new String("yajie");     //构造函数new()后产生不同的独立空间来放置对象

           String s2 = new String("yajie");

           //因为是第一个“yajie”，才会创建，以后的，都不会创建，只会，进行引用的赋值
           String s3 = "yajie";               //为了加快运行速度，放到StringPool中

           String s4 = "yajie";

           String s5 = s1;              //将s1的值赋给s5

           String s6 = s3;              //将s3的值赋给s6

           System.out.println("s1="+s1);

           System.out.println("s2="+s2);

           System.out.println("s3="+s3);

           System.out.println("s4="+s4);

           System.out.println("s5="+s5);

           //都一致，打印后是yajie

           System.out.println("s1 hashcode:"+s1.hashCode());    //打印hashcode

           System.out.println("s2 hashcode:"+s2.hashCode());   

           System.out.println("s3 hashcode:"+s3.hashCode());   

           System.out.println("s4 hashcode:"+s4.hashCode());    //它们都有相同的哈希值

           System.out.println("s5 hashcode:"+s5.hashCode());

           //字符串长度、内容都一致，算法也一样哈希值当然都一致了。

   

           //先把s1和s2比较

           System.out.print("s1==s2:");

           System.out.println(s1==s2); //false

           //用equals()方法比较

           System.out.println("s1.equals(s2):"+s1.equals(s2));     //true

           //s1和s3比较

           System.out.print("s1==s3:");

           System.out.println(s1==s3); //false

           System.out.println("s1.equals(s3):"+s1.equals(s3));     //true

           //s2和s3比较

           System.out.print("s2==s3:");

           System.out.println(s2==s3); //false

           System.out.println("s2.equals(s3):"+s2.equals(s3));     //true

           //s3和s4比较

           System.out.print("s3==s4:");

           System.out.println(s3==s4);         //内存中同一地址 所以为true

           System.out.println("s3.equals(s4):"+s3.equals(s4));     //true

          

           //s5是从s1赋值过来的，它和s4比较地址的结果是false。原因是s5引用的是s1相同的对象，而s4是StringPool中的一个对象

           //s4和s5比较

           System.out.print("s4==s5:");

           System.out.println(s4==s5); //false

           System.out.println("s4.equals(s5):"+s4.equals(s5));     //true

           //s1和s5比较

           //既然s1和s5引用的是同一对象那么s1和s5比较的结果是true!这就说明所引用对象的产生方式不同而不同

           System.out.print("s1==s5:");

           System.out.println(s1==s5); //true

           System.out.println("s1.equals(s5):"+s1.equals(s5));     //true

           //s6和s5比较

           System.out.print("s6==s5:");

           System.out.println(s6==s5); //false

           System.out.println("s6.equals(s5):"+s6.equals(s5));     //true

           /*

                  equals()在API中的描述是:

                  将此字符串与指定的对象比较。(比较内容是否相等)

                  当且仅当该参数不为 null，并且是与此对象表示相同字符序列的 String 对象时，结果才为 true。

                  ==

                  比较操作符 比较的是两个对象的内存地址

           */

    }

   

}