package org.example.ControlStatement;

import java.util.Scanner;

/**
 * Áp dụng nhập vào tháng, năm. In ra số ngày trong tháng.
 * Biết rằng năm nhuận có số năm chia hết 4 thì tháng 2 = 29 ngày
 *
 */
public class SwitchCaseExample {
    public static void main(String[] args) {
        int nam;//=2020;

        int thang;
        //nhập tháng vào từ bàn phím
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập năm, tháng=");
        nam = sc.nextInt();
        thang = sc.nextInt();

        switch (thang) {
            case 1: case 3: case 5: case 7: {
                System.out.println("So ngay = 30");
                break;
            }

            case 4: case 6: case 8: case 9: case 10:case 11: case 12:{
                System.out.println("So ngay = 31");
                break;
            }

            case 2: {
                if ((nam % 4) == 0)
                    System.out.println("so ngay 29");
                else
                    System.out.println("so ngay 28");
                break;
            }

            default:
                System.out.println("du lieu khong hop le");
        }
    }
}
