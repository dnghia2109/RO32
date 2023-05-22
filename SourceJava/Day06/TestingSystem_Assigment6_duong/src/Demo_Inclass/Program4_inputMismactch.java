package Demo_Inclass;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program4_inputMismactch {
	
	public static void main(String[] args) {
		try {
			//tình huống 1
			Scanner s=new  Scanner(System.in);
			System.out.println("age=");
			
			int age=s.nextInt();
			s.close();
		
			System.out.println("age="+age);
			//tình huống 2
			 divide(6,0);
		
		}catch(InputMismatchException e) {
			System.out.println(" lỗi nhập liệu");
		
		}catch(ArithmeticException e) {
			System.out.println(" lỗi thao tác phép chia 0");
			
		}catch (Exception e) {
			System.out.println("có lỗi "+ e.toString());
			
		}
	}
	private static float divide(int i, int j) {
		// TODO Auto-generated method stub
		return i/j;
	}
}
