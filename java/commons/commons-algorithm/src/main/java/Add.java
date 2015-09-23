import java.util.Scanner;
import javax.swing.JOptionPane;

public class Add {
	
	public static void main(String[] args) {
		
		 Scanner input = new Scanner (System.in);
         System.out.println("请输入一个0-1000的整数");
         System.out.println("千位的数为：");
         double a = input.nextDouble();
         System.out.println("百位的数为：");
         double b = input.nextDouble();
         System.out.println("十位的数为：");
         double c =  input.nextDouble();
         System.out.println("个位的数为：");
         double d =  input.nextDouble();
         double e = a*1000+b*100+c*10+d*1;
         input.close();      //solve Resource leak//
         if( e>1000 || e<0)  
        	 JOptionPane.showMessageDialog(null,"非法输入");	   //show GUI dialog box//
         else{
             double f =a+b+c+d;
             System.out.println("该整数的各位数字相加为"+f);
         }
	}

}
