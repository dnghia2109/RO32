package org.example.OnClass.Entity.Entity_Ex5;

import java.util.Scanner;

public class CanBo {
    private String ten;
    private int tuoi;
    private GioiTinh gioiTinh;
    private String diaChi;

    public enum GioiTinh {
        MALE, FEMALE, UNKNOWN
    }

    public CanBo() {
    }

    public CanBo(String ten, int tuoi, GioiTinh gioiTinh, String diaChi) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("- Nhập tên: ");
        setTen(sc.nextLine());

        System.out.println("- Nhập tuổi: ");
        setTuoi(Integer.parseInt(sc.nextLine()));

        System.out.println("- Nhập địa chỉ: ");
        setDiaChi(sc.nextLine());

        System.out.println("- Nhập giới tính (1 - Nam | 2 - Nữ | 3 - Khác ): ");
        int optionGender = Integer.parseInt(sc.nextLine());
        switch (optionGender) {
            case 1 -> setGioiTinh(GioiTinh.MALE);
            case 2 -> setGioiTinh(GioiTinh.FEMALE);
            default -> setGioiTinh(GioiTinh.UNKNOWN);
        }
    }

    @Override
    public String toString() {
        return "ten= '" + ten + '\'' +
                ", tuoi=" + tuoi +
                ", gioiTinh=" + gioiTinh +
                ", diaChi='" + diaChi +  ", ";
    }
}
