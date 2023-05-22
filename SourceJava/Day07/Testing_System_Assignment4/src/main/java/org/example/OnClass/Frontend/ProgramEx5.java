package org.example.OnClass.Frontend;

import org.example.OnClass.Backend.Excercise5;
import org.example.OnClass.Entity.Entity_Ex5.CanBo;
import org.example.OnClass.Entity.Entity_Ex5.CongNhan;

import java.util.*;


public class ProgramEx5 {
    static Excercise5 excercise5 = new Excercise5();
    static List<CanBo> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void initData () {
//        Collections.addAll(list,
//            new CongNhan("Nghia", 22, CanBo.GioiTinh.MALE, "HN", 10),
//            new KiSu("Nghia", 24, CanBo.GioiTinh.MALE, "HN", "CNTT"),
//            new NhanVien("NGHIA", 23, CanBo.GioiTinh.MALE, "HN", "Nghỉ")
//        );

        list.add(new CongNhan("Nghia", 22, CanBo.GioiTinh.MALE, "HN", 10));
    }
    static void menu() {
        System.out.println("==== Chọn các chức năng từ 1-5 ====");
        System.out.println("1. Thêm mới cán bộ.");
        System.out.println("2. Tìm kiếm cán bộ theo họ tên.");
        System.out.println("3. Hiện thị thông tin về danh sách các cán bộ.");
        System.out.println("4. Xóa cán bộ theo tên");
        System.out.println("5. Thoát");
    }

    public static void main(String[] args) {
        initData();
        boolean flag = true;
        while (flag) {
            menu();
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    excercise5.themCanBo(list);
                    break;
                case 2:
                    excercise5.timTheoTen(list);
                    break;
                case 3:
                    excercise5.inDsCongNhan(list);
                    break;
                case 4:
                    excercise5.xoaTheoTen(list);
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("Chọn từ 1 - 5");
                    break;
            }
        }

//        System.out.println("- Nhập số lương công nhân: ");
//        int soCongNhan = Integer.parseInt(sc.nextLine());
//        dsCongNhan = new CongNhan[soCongNhan];
//        for (int i = 0; i < soCongNhan; i++) {
//            System.out.println(" --- Nhân viên thứ " + i+1 + " :");
//            excercise5.themCongNhan(dsCongNhan, i);
//        }
//
//        excercise5.inDsCongNhan(dsCongNhan);
    }
}
