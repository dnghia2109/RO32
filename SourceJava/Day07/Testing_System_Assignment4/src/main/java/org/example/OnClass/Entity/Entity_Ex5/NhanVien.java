package org.example.OnClass.Entity.Entity_Ex5;

import java.util.Scanner;

public class NhanVien extends CanBo{
    private String congViec;

    public NhanVien() {
    }

    public NhanVien(String name, int age, GioiTinh gioiTinh, String address, String congViec) {
        this.congViec = congViec;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    @Override
    public void setData() {
        super.setData();
        Scanner sc = new Scanner(System.in);
        System.out.println("- Nhập công việc: ");
        setCongViec(sc.nextLine());
    }

    @Override
    public String toString() {
        return "NhanVien{" + super.toString() +
                " congViec='" + congViec + '\'' +
                '}';
    }
}
