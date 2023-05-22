package org.example.OnClass.Frontend;

import org.example.OnClass.Backend.DepartmentControl;
import org.example.OnClass.Entity.Department;

import java.util.Random;
import java.util.Scanner;

public class Program2 {
    //static Program2 program2 = new Program2();
    static Scanner sc = new Scanner(System.in);

    static Department[] departments;
    static DepartmentControl departmentControl = new DepartmentControl();

    public static void menu() {
        System.out.println("1. Tạo DS phòng ban");
        System.out.println("2. In DS phòng ban");
        System.out.println("3. Tạo DS vị trí Position");
        System.out.println("4. Tạo DS ");
        System.out.println("5. ");
        System.out.println("6. ");
        System.out.println("7. ");
        System.out.println("8. ");
        System.out.println("9. Thoát");
    }

    public static void main(String[] args) {
        while (true) {
            menu();
            System.out.println("Chọn các chức năng từ 1-9: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    departments = departmentControl.createDepartment();
                    break;
                case 2:
                    departmentControl.printDepartment(departments);
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Chọn các chức năng từ 1-9 ! ");
            }
        }
    }


}
