package org.example.OnClass.Entity.Entity_Ex5;

import java.util.Scanner;

public class CongNhan extends CanBo{
    private int bac; // 1-10

    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }

    public CongNhan() {
    }

    public CongNhan(String name, int age, GioiTinh gioiTinh, String address, int bac) {
        super();
        this.bac = bac;
    }

    @Override
    public void setData() {
        super.setData();
        Scanner sc = new Scanner(System.in);
        System.out.println("- Nhập bậc: ");
        setBac(Integer.parseInt(sc.nextLine()));
    }

    @Override
    public String toString() {
        return "CongNhan{" + super.toString() +
                " bac=" + bac +
                '}';
    }
}
