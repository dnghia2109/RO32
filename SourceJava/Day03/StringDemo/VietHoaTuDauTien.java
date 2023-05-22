package StringDemo;

public class VietHoaTuDauTien {
	public static void main(String[] args) {
		String str = "what happen in your class?";
		//cắt string thành mảng qua các dấu Space
		String[] arr = str.split(" ");
		//dùng vòng lặp duyệt các từ và thay thế từ đầu tiên!
		String str1 = "";
		for (String x : arr) {
			str1 = str1 + (x.substring(0, 1).toUpperCase() + x.substring(1));
			str1 = str1 + " ";
		}
		System.out.println("Biến các chữ đầu thành hoa: " + str1);
	}

}
