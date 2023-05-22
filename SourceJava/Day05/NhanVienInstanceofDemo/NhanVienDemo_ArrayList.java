/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NhanVienInstanceofDemo;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Vu Thi Duong
 */
public class NhanVienDemo_ArrayList 
{
    static ArrayList<NhanVien> dsnv=new ArrayList<NhanVien>();
    static double tongLuong=0f;
    static  int soNV;
    static void nhap()
    {
        int loaiNV;     
         NhanVien nv;
        Scanner s=new Scanner(System.in);
        System.out.print("Nhap so luong nhan vien=");
        soNV=s.nextInt();

        for(int i=0;i<soNV;i++)
        {               
            System.out.print("1.Nhập NVSX, 2.NVVP");
            loaiNV=s.nextInt();
            if (loaiNV==1)
                  nv=new NhanVienSX();
            else
                  nv=new NhanVienVP();
            nv.nhap();          
            //them vao ds
            dsnv.add(nv);
            tongLuong=tongLuong+nv.tinhLuong()    +nv.tinhPhuCap();
      }
    }
    static void inDSNV()
    {
         System.out.println("\nDanh sach nhan vien SAN XUAT cong ty la");
         for(NhanVien nv:dsnv) 
                if (nv instanceof NhanVienSX )System.out.println(nv);
         
         System.out.println("\nDanh sach nhan vien VAN PHONG cong ty la");         
         for(NhanVien nv:dsnv) 
                if (nv instanceof NhanVienVP )System.out.println(nv);
         
      DecimalFormat f = new DecimalFormat("###,###.0#");
      System.out.println("Tong luong nhan vien:"  + f.format(tongLuong));
    }
   //tim NhanVien
    static int timNV(String maNV)
    {
        NhanVien nv=new NhanVien(maNV) {
            @Override
            public double tinhLuong() {
                return 0;
            }
        } ;
        if (dsnv.contains(nv))
            return dsnv.indexOf(nv);
        else return -1;
    }
    static void sapXep()
    {
        Comparator c=new Comparator<NhanVien>() {

            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                int t=o1.maNv.compareToIgnoreCase(o2.maNv);
                if (t==0)
                    if (o1.namVaoLam==o2.namVaoLam) t=0;
                    else if (o1.namVaoLam>o2.namVaoLam) t=1;
                    else t=-1;
                return t;
            }            
        }; 
        Collections.sort(dsnv, c);
    }
    public static void main(String[] args) {
        nhap();
        inDSNV();
        // ------------------------------------
//        Scanner s=new Scanner(System.in);
//        System.out.print("nhap ma nv cần tìm=");
//        String ma=s.nextLine();
//        int vitri=timNV(ma);
//        if (vitri>=0)
//        {
//            if (dsnv.get(vitri) instanceof  NhanVienSX)
//                System.out.println("Nhan vien tim duoc là nvsx");
//            else System.out.println("Nhan vien tim duoc la nvvp");                    
//            System.out.println(dsnv.get(vitri));
//        }
//        else
//            System.out.println("khong tim duoc nv");
        // ------------------------------------
        System.out.println("DS nv sau khi sap: ");
        sapXep();
        inDSNV();
    }
    
    
}

