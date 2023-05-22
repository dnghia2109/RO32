package StringDemo;

import java.util.StringTokenizer;

public class DemSoTuTrongCau {
	public static void main(String[] args) {
		String str = "Cộng hòa xã hội chủ nghĩa Việt Nam";

		StringTokenizer defaultTokenizer = new StringTokenizer(str);
		System.out.println("Tổng số từ : " + defaultTokenizer.countTokens());
		while (defaultTokenizer.hasMoreTokens()){
		    System.out.println(defaultTokenizer.nextToken());
		}
		System.out.println("Tổng số từ: " + defaultTokenizer.countTokens());

	}

}
