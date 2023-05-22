package org.example.OnClass.Entity.Entity_Ex6;

import java.util.ArrayList;

public class VietnamesePhone extends Phone{
    @Override
    public void insertContact(String name, String phone) {
        Contact c = new Contact(phone, name);
        contacts.add(c);
    }

    @Override
    /**
     * b1: tạo đối tượng theo mẫu cần tìm
     * dùng indexOf xac định vị trí
     * gọi hàm remove để xóa phần tử tại vị trí
     */
    public void removeContact(String name) {
//        contacts.removeIf(contact -> contact.getName().equals(name));
//        Contact c = new Contact(name);
//        if (!contacts.contains(c)) {     //Contact(Nghia), Contact(NGhia,09)
//            System.out.println("Không có contact có tên này");
//        } else {
//            int viTri = contacts.indexOf(c);
//            contacts.remove(viTri);
//        }
    }

    @Override
    public void updateContact(String name, String newPhone) {
        Contact c = new Contact(name);
        //ktra nếu có thì update, ko thì thôi
        if (!contacts.contains(c))
            System.out.println("khong có tên này");
        else {
            int viTri = contacts.indexOf(c);
            //tạo pt moi với tên mới và phone cũ
            Contact cNew = new Contact(name, newPhone);
            contacts.set(viTri,cNew);
        }

    }


    @Override
    public void searchContact(String name) {
        // TODO Auto-generated method stub
        Contact c = new Contact(name);
        //ktra nếu có thì update, ko thì thôi
        if (!contacts.contains(c))
            System.out.println("khong có tên này");
        else {
            System.out.println(c);
        }
    }




}

