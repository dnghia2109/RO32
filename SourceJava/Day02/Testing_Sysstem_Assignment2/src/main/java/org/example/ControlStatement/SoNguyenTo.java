package org.example.ControlStatement;

public class SoNguyenTo {
    public static void kiemTraSoNguyenTo(int n) {
        boolean flag = false;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("Khong la so nguyen to");
        } else {
            System.out.println("La so nguyen to");
        }

        //System.out.println(flag == false ? n + "la so nguyen to" : n + " khong la so nguyen to");

    }

    public static void main(String[] args) {
        kiemTraSoNguyenTo(7);
        boolean flag = false;
        int n = 7;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if ((n % i) == 0) {
                flag = true;
                break;
            }
        }

        System.out.println(!flag ? n + " la so nguyen to" : n + " khong la so nguyen to");
    }


}
