package org.example.OnClass.Entity.Entity_Ex5;

import java.util.Scanner;

public class KiSu extends CanBo{
    private String nganhDaoTao;

    public KiSu() {
    }

    public KiSu(String name, int age, GioiTinh gioiTinh, String address, String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    @Override
    public void setData() {
        super.setData();
        this.nganhDaoTao = nganhDaoTao;
        Scanner sc = new Scanner(System.in);
        System.out.println("- Nhập ngành đào tạo: ");
        setNganhDaoTao(sc.nextLine());
    }

    @Override
    public String toString() {
        return "KiSu{" + super.toString() +
                " nganhDaoTao='" + nganhDaoTao + '\'' +
                '}';
    }
}
