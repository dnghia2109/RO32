package org.example.OnClass.Backend;

import org.example.OnClass.Entity.Department;

import java.util.Random;
import java.util.Scanner;

public class DepartmentControl {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();
    public Department[] createDepartment() {
        System.out.println("Nhập số phòng muốn tạo: ");
        int n = sc.nextInt();
        // Khởi tạo mảng -- Cú pháp: tên mảng = new tên_class[số phần tử];
        Department[] departments = new Department[n];
        for (int i = 0; i < n; i++) {
            departments[i] = new Department();
            departments[i].setId(rd.nextInt(100));
            departments[i].setName("Department" + departments[i].getId());
        }
        return departments;
    }

    public void printDepartment(Department[] departments) {
        for (Department department : departments) {
            department.printData();
        }
    }
}
