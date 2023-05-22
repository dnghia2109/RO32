package org.example.ControlStatement;

public class GiaiThua {

    public static long tinhGiaiThua(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static void main(String[] args) {
        long rs = tinhGiaiThua(5);
        System.out.println(rs);
    }
}
