
import javax.swing.JOptionPane;

public class Employee extends Person {
	private int money=50000;//数据
    Mydate date=new Mydate();//读入日期

    public int getMoney() {
    	return money;
    }
  //访问方法
    public void setMoney(int money) {
	    this.money = money;
    }
  //toString方法
    public String toString(){
	    return s="Employee类："+super.toString()+" "+"工资为："+getMoney()+" "+"受聘日期为："+date.getDate();
    }
  //弹出GUI对话框
    public void showDiag(){
	    JOptionPane.showMessageDialog(null, " To "+getName()+": 请按时上班");
    } 
}
