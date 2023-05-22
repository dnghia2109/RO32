/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NhanVienInstanceofDemo;


import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

abstract class NhanVien{
    protected String maNv; 
    protected String hoTen; 
    protected int namVaoLam;
    static double tongLuong;
    final double PHUCAP_BANDAU=100000;
    abstract public double tinhLuong();
    //lấy mã nhân viên
    public String getMaNv() {
        return maNv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public int getNamVaoLam() {
        return namVaoLam;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNamVaoLam(int namVaoLam) {
        this.namVaoLam = namVaoLam;
    }

    public static void setTongLuong(double tongLuong) {
        NhanVien.tongLuong = tongLuong;
    }

    public static double getTongLuong() {
        return tongLuong;
    }

    public double getPHUCAP_BANDAU() {
        return PHUCAP_BANDAU;
    }
    
    protected double tinhPhuCap() {            
        Date now = new Date();
        int d=LocalDate.now().getYear();
        return PHUCAP_BANDAU+(d-namVaoLam)*20000;
    }   
    public NhanVien(String maNv) {
        this.maNv = maNv;
        this.hoTen = "";
        this.namVaoLam = 2012;
    }
    public NhanVien() {
        this.maNv = "nv0";
        this.hoTen = "";
        this.namVaoLam = 2000;
    }

   public void nhap() {
     Scanner s=new Scanner(System.in);
     System.out.print("Nhap ma nv ="); 
     maNv=s.nextLine();
     System.out.print("Nhap ho ten="); 
     hoTen=s.nextLine();
     System.out.print("Nhap nam vao lam="); 
     namVaoLam=s.nextInt();   
    }
    public static void inTieuDe() {
        System.out.printf("%-10s %-15s %6s "," Ma nv", " ho ten","năm vào làm" );    
    }
    public  void xuatDL(){
        System.out.printf("%-10s %-15s %6d ",maNv,hoTen,namVaoLam );    
    }          
}



