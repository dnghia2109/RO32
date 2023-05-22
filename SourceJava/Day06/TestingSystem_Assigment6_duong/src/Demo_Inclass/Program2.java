package Demo_Inclass;

public class Program2 {
	public static void main(String[] args) {
		int[] numbers= {-1,1,3,5,-5,-8};

		try {
			System.out.println(numbers[10]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Xảy ra lỗi khi truy cập phần tử nằm ngoài phạm vi của mảng");
		} catch (Exception e) {
			System.out.println("Có lỗi sau: " + e.toString());
		}

		System.out.println("Có thể viết code tiếp tại đây");
	}
}
