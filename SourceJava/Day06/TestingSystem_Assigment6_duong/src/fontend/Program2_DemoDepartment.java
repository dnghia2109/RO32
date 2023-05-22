package fontend;

import java.util.Scanner;

import backend.Excercise2;

public class Program2_DemoDepartment {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int vitri;
		Excercise2 ex2= new Excercise2();
		ex2.outputDepat();
		System.out.println("nhap vi tri phong");
		vitri=s.nextInt();
		System.out.println("thong tin phong:" + ex2.getIndex(vitri));
		s.close();
	}
}
