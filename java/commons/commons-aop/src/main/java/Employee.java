
import javax.swing.JOptionPane;

public class Employee extends Person {
	private int money=50000;//����
    Mydate date=new Mydate();//��������

    public int getMoney() {
    	return money;
    }
  //���ʷ���
    public void setMoney(int money) {
	    this.money = money;
    }
  //toString����
    public String toString(){
	    return s="Employee�ࣺ"+super.toString()+" "+"����Ϊ��"+getMoney()+" "+"��Ƹ����Ϊ��"+date.getDate();
    }
  //����GUI�Ի���
    public void showDiag(){
	    JOptionPane.showMessageDialog(null, " To "+getName()+": �밴ʱ�ϰ�");
    } 
}
