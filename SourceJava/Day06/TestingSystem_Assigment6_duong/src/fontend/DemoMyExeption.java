package fontend;

import java.util.Scanner;

import backend.MyException;

public class DemoMyExeption {
	public static void main(String[] args) {
		int age;
		try {
			age = inputAge();
			System.out.println("age:"+age);
		} catch (MyException e) {
			System.out.println(" co loi "+ e.toString());
//			e.printStackTrace();
		}
		
	}
	public static int inputAge()  throws MyException{
		try {
			System.out.println("input your age:");
			Scanner s=new Scanner(System.in);
			int age=s.nextInt();
			return age;
		}catch (Exception e) {
//			return 0;
			throw new MyException("input a number as int");
		}
	
	}

}
