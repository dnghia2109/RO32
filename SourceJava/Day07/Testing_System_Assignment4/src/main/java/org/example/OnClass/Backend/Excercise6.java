package org.example.OnClass.Backend;

import org.example.OnClass.Entity.Entity_Ex6.Contact;
import org.example.OnClass.Entity.Entity_Ex6.VietnamesePhone;

import java.util.ArrayList;
import java.util.Scanner;

public class Excercise6 {
    VietnamesePhone vietnamesePhone = new VietnamesePhone();
    Scanner sc = new Scanner(System.in);
    public void inputPhone() {
        while (true) {
            String name, phone;
            System.out.println("- Nhập tên, phone:");
            name = sc.nextLine();
            if (name.trim().length() == 0) {
                break;
            }
            phone = sc.nextLine();
            vietnamesePhone.insertContact(name, phone);
        }
    }

    public void  getAllContact() {
        for (Contact contact: vietnamesePhone.getContacts()) {
            System.out.println(contact);
        }
    }

    public void removeContact() {
        System.out.println("- Nhập tên cần xóa: ");
        String removeName = sc.nextLine();
        vietnamesePhone.removeContact(removeName);
    }

    public static void main(String[] args) {


    }

}
