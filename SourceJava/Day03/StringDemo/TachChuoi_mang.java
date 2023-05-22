package StringDemo;

import java.util.Arrays;
import java.util.regex.Pattern;

public class TachChuoi_mang {
	public static void main(String[] args) {
		String str = "Cộng hòa    xã hội chủ nghĩa Việt Nam";
		String[] arrStr;
		arrStr=str.split(" ");
//		System.out.println("first str: "+Arrays.toString(arrStr));
		//Cách 2 sử dụng Pattern.split()
		Pattern pattern = Pattern.compile(" ");
		arrStr = pattern.split(str); //[how, to, do, in, java]
		//in mảng
		System.out.println("first str: "+Arrays.toString(arrStr));
		//ghép lại mảng thành chuỗi String.join
		String strNew=String.join(" " , arrStr);
		System.out.println("second str: "+strNew);
	}

}
