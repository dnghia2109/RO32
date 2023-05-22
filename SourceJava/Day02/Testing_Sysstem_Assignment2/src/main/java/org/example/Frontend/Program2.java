package org.example.Frontend;

import org.example.Entity.Department;

import java.util.Random;
import java.util.Scanner;

public class Program2 {
    static Program2 program2 = new Program2();
    Department[] departments;
    Scanner sc = new Scanner(System.in);

    public static void menu() {
        System.out.println("1. Tạo DS phòng ban");
        System.out.println("2. In DS phòng ban");
        System.out.println("3. Tạo DS vị trí Position");
        System.out.println("4. ");
        System.out.println("9. Thoát");
    }

    void createDepartment() {
        Random rd = new Random();
        System.out.println("Nhập số phòng muốn tạo: ");
        int n = sc.nextInt();
        // Khởi tạo mảng -- Cú pháp: tên mảng = new tên_class[số phần tử];
        departments = new Department[n];
        for (int i = 0; i < n; i++) {
            departments[i] = new Department();
            departments[i].id = rd.nextInt(100);
            departments[i].name = "Department" + departments[i].id;
        }
    }

    void printDepartment() {
        for (Department department : departments) {
            department.printData();
        }
    }

    static void printAccount() {

    }

    public static void main(String[] args) {
//        int option = 1;
//        menu();
        Scanner sc = new Scanner(System.in);
        while (true) {
            menu();
            System.out.println("Chọn các chức năng từ 1-9: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    program2.createDepartment();
                    break;
                case 2:
                    program2.printDepartment();
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Chọn các chức năng từ 1-9 ! ");
            }
        }
    }


}
