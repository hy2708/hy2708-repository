import java.util.Scanner;
import javax.swing.JOptionPane;

public class Add {
	
	public static void main(String[] args) {
		Integer.valueOf("");
		 Scanner input = new Scanner (System.in);
         System.out.println("������һ��0-1000������");
         System.out.println("ǧλ����Ϊ��");
         double a = input.nextDouble();
         System.out.println("��λ����Ϊ��");
         double b = input.nextDouble();
         System.out.println("ʮλ����Ϊ��");
         double c =  input.nextDouble();
         System.out.println("��λ����Ϊ��");
         double d =  input.nextDouble();
         double e = a*1000+b*100+c*10+d*1;
         input.close();      //solve Resource leak//
         if( e>1000 || e<0)  
        	 JOptionPane.showMessageDialog(null,"�Ƿ�����");	   //show GUI dialog box//
         else{
             double f =a+b+c+d;
             System.out.println("������ĸ�λ�������Ϊ"+f);
         }
	}

}
