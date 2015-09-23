package example;
import java.util.*;
import javax.swing.*;

public class Exercise2_6 {

	/**
	 * @param args
	 */
	//Main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Read the number
		Scanner input = new Scanner (System.in);
		System.out.println("Please enter a number between 0 and 1000:");
		int num = input.nextInt();
		
		if(num>0 && num<1000)
		{
			//Get the digits
			int z=num%10;
			int x=num/100;
			int y=((num-z)/10)%10;
			//Obtain the sum
			int sum=x+y+z;
			//Display the sum
		    System.out.println("The sum of all digits in "+num+" is:"+sum);
		}
		//Return the Error
		else JOptionPane.showMessageDialog(null,"Error the number you enter","Warning",JOptionPane.INFORMATION_MESSAGE);
	}

}
