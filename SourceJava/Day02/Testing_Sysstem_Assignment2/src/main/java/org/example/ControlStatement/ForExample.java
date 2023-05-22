package org.example.ControlStatement;

public class ForExample {
    public static void main(String[] args) {
        int a[]= {4,5,6,7,8,9,2};
        for (int i : a) {
            System.out.printf("%-5d", i);//căn trái giá trị in ra/ thừa phải
        }
        System.out.printf("%n");

        for (int i = 0 ; i < a.length ; i++) {
            System.out.printf("%5d", a[i]);//mặc định căn phải, thừa để trái
        }
//		System.out.printf("%n");
//		for(int i=1;i<20;) {
//			i=i+2;
//			//có thể trong thuật toan sử dụng lệnh vô tình tác động lên i
//			i=i+3;
//			System.out.printf("%5d",i);
//		}
    }
}
