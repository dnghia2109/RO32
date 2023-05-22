package org.example.OnClass.Frontend;

import org.example.OnClass.Backend.Excercise6;
import org.example.OnClass.Entity.Entity_Ex6.Contact;

import java.util.Scanner;

public class ProgramEx6 {

    static void menu() {
        System.out.println("1. Thêm contact.");
        System.out.println("2. Xóa contact theo tên.");
        System.out.println("3. Tìm kiếm theo tên.");
        System.out.println("4. Thoát");
    }

    public static void main(String[] args) {
        Excercise6 excercise6 = new Excercise6();
        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            menu();
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    excercise6.inputPhone();
                    break;
                case 2:
                    excercise6.getAllContact();
                    break;
                case 3:
                    excercise6.removeContact();
                    excercise6.getAllContact();
                    break;
                case 4:
                    flag = false;
                    break;
            }
        }


    }
}
