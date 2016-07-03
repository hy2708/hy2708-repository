
public class E1 {
	public static void main(String args[]){
		//实例化类
		Person p1=new Person();
		Person p2=new Students();
		Person p3=new Employee();
		//调用方法
		m1(p1);m2(p1);m3(p1);
		m1(p2);m2(p2);m3(p2);
		m1(p3);m2(p3);m3(p3);
		
	}
   
	public static void m1(Person p){
		System.out.println(p.getName());
	}
	public static void m2(Person p){
		System.out.println(p.toString());
	}
	public static void m3(Person p){
        if(p instanceof Students){
        	((Students) p).showDiag();
        }
        if(p instanceof Employee){
        	((Employee) p).showDiag();
        }
	}
}


