

import javax.swing.JOptionPane;

public class Students extends Person {
	private String grade;
  //���峣��
    public static final String a="��һ";
    public static final String b="���";
    public static final String c="����";
    public static final String d="����";
  //���ʷ���
    public String getGrade(String a2) {
    	return grade;
    }
    public void setGrade(String grade) {
    	this.grade = grade;
    }
  //toString����
    public String toString(){
	    return s="Student�ࣺ"+super.toString()+" "+"�꼶Ϊ��"+" "+a;
    }
  //����GUI�Ի���
    public void showDiag(){
	    JOptionPane.showMessageDialog(null, " To "+getName()+"ͬѧ���밴ʱ��ʵ�鱨��");
    }
}

