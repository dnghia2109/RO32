package StringDemo;
/*
 * https://freetuts.net/viet-hoa-ky-tu-dau-tien-trong-java-3552.html
 * tách chữ ban đầu thành hai phần: 1 phần là ký tự đầu tiên của chữ và phần thứ hai là các ký tự còn lại.
   toUpperCase() để in hoa phần đầu tiên rồi gộp hai phần đó lại.
 */
public class VietHoa1Tu {
	public static void main(String[] args) {
		//khai báo và khởi tạo một string name
	    String name = "net";
	    System.out.println("\n\nChuỗi ban đầu: " + name);
	    // tạo hai chuỗi con firstLetter và remainingLetters
	    // chuỗi firstLetter chứa chữ cái đầu tiên của  name
	    String firstLetter = name.substring(0, 1);
	    // chuỗi remainingLetters chứa phần còn lại của name
	    String remainingLetters = name.substring(1, name.length());
	 
	    //sử dụng phương thức toUpperCase() để chuyển đổi firstLetter thành chữ in hoa
	    firstLetter = firstLetter.toUpperCase();
	 
	    //sau khi chuyển đổi thì gộp chúng lại
	    name = firstLetter + remainingLetters;
	    System.out.println("Chuỗi sau khi đổi: " + name);
	 
	    System.out.println("\n---------------------------------");
	    System.out.println("Chương trình này được đăng tại Freetuts.net");
	  }
		
	}



