package Demo_Inclass;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
	private Scanner s;
	private String name;
	private int age;

	public Student() throws Exception {
		s = new Scanner (System.in);
		name = inputName();
		age = inputAge();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private int inputAge() throws Exception {
		try {
			System.out.println("input your age:");
			int age = s.nextInt();
			return age;
		} catch (InputMismatchException e) {
			throw new Exception("Nhập tuổi là 1 số nguyên.");
		} catch (Exception e) {
			throw new Exception("Tuổi của bạn phải trên 18 !!!");
		}
	}

	private String inputName() throws Exception {
		try {
			System.out.println("input your name:");
			String name=s.nextLine();
			return name;
		} catch (Exception e) {
			throw new Exception("Hãy nhập đúng tên của bạn !!!");
		}
	}

	public static void main(String[] args) {
		try {
			Student student = new Student();
			System.out.println("Tên của student: " + student.getName());
			System.out.println("Tuổi của student: " + student.getAge());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
