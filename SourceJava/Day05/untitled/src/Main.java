import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
//        Scanner scNhapDsSv = new Scanner(System.in);
//        System.out.println("Nhap so sinh vien:");
//        int soSv = scNhapDsSv.nextInt();
//        ArrayList<SinhVien> lstSinhVien = new ArrayList<SinhVien>();
//        for (int i = 0; i < soSv; i++) {
//            SinhVien s = new SinhVien();
//            System.out.println("Moi nhap sinh vien:" + i + "\r\n");
//            s.nhap();
//            lstSinhVien.add(s);
//        }
//        for (SinhVien sinhVien : lstSinhVien) {
//            sinhVien.xuat();
//        }
        SinhVien sinhVien = new SinhVien();
        sinhVien.nhap();
        System.out.println(sinhVien.xepLoai());
        //sinhVien.xepLoai();
        sinhVien.xuat();



    }
}