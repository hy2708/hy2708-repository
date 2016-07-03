package org.hy.commons.io.core;

import java.io.*;

class Student implements Serializable // 必须实现Serializable接口才能序列化
{
	transient Thread thread;
	int age;
	String name;

	Student(int age, String name) {
		this.age = age;
		this.name = name;
	}
}

public class Iotest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu1 = new Student(20, "zhangsan");
		Student stu2 = new Student(22, "lisi");
		Student stu3 = new Student(28, "wangwu");
		ObjectInputStream ois = null;
		try {
			FileOutputStream fos = new FileOutputStream("aa.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(stu1);
			oos.writeObject(stu2);
			oos.writeObject(stu3);

			oos.close();

			FileInputStream fis = new FileInputStream("aa.txt");
			ois = new ObjectInputStream(fis);
			Object object = null;
			while ((object =ois.readObject())!=null) {
				if (object instanceof Student) {
					System.out.println("age: " + ((Student)object).age);
					System.out.println("name: " + ((Student)object).name);
					
				}
			};

		}catch (EOFException e) { //在读取到文件结束时触发此异常
			System.out.println("End of file reached.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(ois!=null){
					ois.close();
					System.out.println("close");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
