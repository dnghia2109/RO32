package Demo_Inclass;

import java.util.Scanner;

public class Exercise2_exeption {
	public static void main(String[] args) {
		int age;
		try {
			age = inputAge();
			System.out.println("age:"+age);
		} catch (Exception e) {
			System.out.println(" co loi "+ e.toString());
//			e.printStackTrace();
		}
		
	}
	public static int inputAge()  throws Exception{
		try {
			System.out.println("input your age:");
			Scanner s=new Scanner(System.in);
			int age=s.nextInt();
			return age;
		}catch (Exception e) {
//			return 0;
			throw new Exception("input a number as int");
		}
	
	}
}
