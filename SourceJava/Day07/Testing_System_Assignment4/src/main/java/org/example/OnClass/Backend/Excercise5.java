package org.example.OnClass.Backend;

import org.example.OnClass.Entity.Entity_Ex5.CanBo;
import org.example.OnClass.Entity.Entity_Ex5.CongNhan;
import org.example.OnClass.Entity.Entity_Ex5.KiSu;
import org.example.OnClass.Entity.Entity_Ex5.NhanVien;

import java.util.List;
import java.util.Scanner;

// Đây là class service
public class Excercise5 {
    Scanner sc = new Scanner(System.in);



    // Question 2:
    // a) Thêm mới cán bộ.
    public void themCanBo(List<CanBo> list) {
        System.out.println("==== Chọn cán bộ muốn thêm ====");
        System.out.println("1. Thêm Kĩ sư.");
        System.out.println("2. Thêm Công nhân.");
        System.out.println("3. Thêm Nhân viên.");
        System.out.println("4. Quay lại");
        int option = Integer.parseInt(sc.nextLine());
        switch (option) {
            case 1:
                KiSu kiSu = new KiSu();
                kiSu.setData();
                list.add(kiSu);
                break;
//                System.out.println("- Nhập tên Kĩ sư:");
//                kiSu.setTen(sc.nextLine());
//
//                System.out.println("- Nhập tuổi: ");
//                kiSu.setTuoi(Integer.parseInt(sc.nextLine()));
//
//                System.out.println("- Nhập giới tính (1 - Nam | 2 - Nữ | 3 - Khác ): ");
//                int optionGender = Integer.parseInt(sc.nextLine());
//                switch (optionGender) {
//                    case 1 -> kiSu.setGioiTinh(CanBo.GioiTinh.MALE);
//                    case 2 -> kiSu.setGioiTinh(CanBo.GioiTinh.FEMALE);
//                    default -> kiSu.setGioiTinh(CanBo.GioiTinh.UNKNOWN);
//                }
            case 2:
                CongNhan congNhan = new CongNhan();
                congNhan.setData();
                list.add(congNhan);
                break;
            case 3:
                NhanVien nhanVien = new NhanVien();
                nhanVien.setData();
                list.add(nhanVien);
                break;
        }
    }

    // b) Tìm kiếm thoe họ tên
    public void timTheoTen(List<CanBo> list) {
        System.out.println("Nhập vào tên cán bộ muốn tìm kiếm: ");
        String findName = sc.next();

        for (CanBo canBo : list) {
            if (canBo.getTen().equalsIgnoreCase(findName)) {
                System.out.println(canBo);
            } else {
                System.out.println("Không tìm thấy cán bộ có tên - " + findName +" trong danh sách !");
            }
        }
    }

    // c) Hiện thị thông tin về danh sách các cán bộ
    public void inDsCongNhan(List<CanBo> list) {
        for (CanBo canBo: list) {
            System.out.println(canBo);
        }
    }

    // d) Xóa cán bộ theo tên
    public void xoaTheoTen(List<CanBo> list) {
        System.out.println("Nhập vào tên cán bộ muốn xóa: ");
        String findName = sc.next();
        for (CanBo canBo : list) {
            if (canBo.getTen().equalsIgnoreCase(findName)) {
                list.remove(canBo);
                System.out.println("Xóa thành công cán bộ có tên - " + findName + " !");
            } else {
                System.out.println("Không tìm thấy cán bộ có tên - " + findName +" trong danh sách !");
            }
        }
    }




//    public void themCongNhan(CongNhan[] list, int viTri) {
//        CongNhan congNhan = new CongNhan();
//        congNhan.setData();
//        list[viTri] = congNhan;
//
//    }
//
//    public void inDsCongNhan(CongNhan[] list) {
//        for (CongNhan congNhan: list) {
//            System.out.println(congNhan);
//        }
//    }
//
//    public void timCongNhan(CongNhan[] list, String ten) {
//        for (CongNhan cn:
//             list) {
//            if (cn.getTen().equalsIgnoreCase(ten)) {
//                System.out.println(cn);
//            }
//        }
//    }

}
