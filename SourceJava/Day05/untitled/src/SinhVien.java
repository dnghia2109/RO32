import java.util.Scanner;
import java.util.ArrayList;

public class SinhVien {
    private String hoTen, diaChi, gioiTinh;
    private double diem;

    public SinhVien() {

    }

    public SinhVien(String hoTen, String diaChi, String gioiTinh, double diem) {
        super();
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.diem = diem;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public void nhap() {
        Scanner scNhap = new Scanner(System.in);
        System.out.println("Moi nhap ho ten:");
        this.hoTen = scNhap.nextLine();
        System.out.println("Moi nhap dia chi: ");
        this.diaChi = scNhap.nextLine();
        System.out.println("Moi nhap gioi tinh: ");
        this.gioiTinh = scNhap.nextLine();
        System.out.println("Moi nhap diem: ");
        this.diem = scNhap.nextDouble();
    }

    public String xepLoai() {
        String rs;
        if (this.diem <= 5)
            rs = "Yeu";
        else if (5 <= this.diem && this.diem < 6.5)
            rs = "Trung Binh";
        else if (6.5 <= this.diem && this.diem < 8)
            rs = "Kha";
        else
            rs = "Gioi";
        return rs;
    }

    public void xuat() {
        System.out.println("Ten SV: " + this.hoTen + "\r\nDia chi: " + this.diaChi + "\r\nGioi tinh: " + this.gioiTinh
                + "\r\nDiem: " + this.diem);
    }

}
