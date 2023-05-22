/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NhanVienInstanceofDemo;

import java.util.Date;
import java.util.Scanner;

class NhanVienSX  extends NhanVien{   
    private int soSanPham;    
    public NhanVienSX(String maNv){
        super(maNv);
        soSanPham=0;
    }
    public NhanVienSX() {
        super();
        soSanPham=0;
    }
    public double tinhLuong()
    { 
        return soSanPham*10000;
    }        
    
    @Override
    public void nhap() { 
        super.nhap();
        Scanner s=new Scanner(System.in);
        System.out.print("Nhap so san pham="); 
        soSanPham=s.nextInt();      
    }  
    public static void inTieuDe(){
        NhanVien.inTieuDe();
        System.out.printf("%10s %15s %15s%n"," So sp", " phu cap"," Luong");
    }
    public  void xuatDL(){
        super.xuatDL();
        System.out.printf("%10d %15.2f %15.2f%n",soSanPham,tinhPhuCap(),tinhLuong());
    }
    public void setSoSanPham(int soSanPham) {
        this.soSanPham = soSanPham;
    }
    public int getSoSanPham() {
        return soSanPham;
    }
  
}
    
