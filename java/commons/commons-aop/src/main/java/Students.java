

import javax.swing.JOptionPane;

public class Students extends Person {
	private String grade;
  //定义常量
    public static final String a="大一";
    public static final String b="大二";
    public static final String c="大三";
    public static final String d="大四";
  //访问方法
    public String getGrade(String a2) {
    	return grade;
    }
    public void setGrade(String grade) {
    	this.grade = grade;
    }
  //toString方法
    public String toString(){
	    return s="Student类："+super.toString()+" "+"年级为："+" "+a;
    }
  //弹出GUI对话框
    public void showDiag(){
	    JOptionPane.showMessageDialog(null, " To "+getName()+"同学：请按时交实验报告");
    }
}

