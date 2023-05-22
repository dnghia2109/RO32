package StringDemo;

import java.io.ObjectInputStream.GetField;

public class ChuanHoaChuoi {
	/**
	 * charAt(int index) - trả về 1 ký tự tại vin trí index
	 * @param fullname
	 * @return
	 */
	public static String getFullnameFormat(String fullname){
		String tmp = fullname.trim();
		int blankCount=0;
		for(int i=0; i<tmp.length();i++){
			if(tmp.charAt(i)==' '){
			   for (int j=i; j < tmp.length(); j++) {
				if(tmp.charAt(j)==' '){
					blankCount++;
				}else{break;}
			   }
			   tmp = tmp.substring(0,i)+ 
					   tmp.subSequence(i+blankCount-1,tmp.length());
			   blankCount=0;
			}
		}
		return tmp;
	}
	public static String getFullnameFormat_v2(String fullname){
			    
	    System.out.println("\n\nChuỗi ban đầu: " + fullname);
	    //sử dụng phương thức replaceAll() để xóa khoảng trắng
	    fullname = fullname.replaceAll("  ", "");
	    System.out.println("Chuỗi sau khi xóa khoảng trắng: " + fullname);
	 
	    System.out.println("\n----------------------------------");
	    
	    return fullname;
	  }
	public static int demSoTuTrongCau(String s) {
		int dem=0;
		for(int i=0; i<s.length();i++)
			if(s.charAt(i)==' '){
				dem++;
			}
		return dem;
	}

	public static void main(String[] args) {
		String s=" Cộng hòa xx xã hội   chủ    ";
		String result="";
		int dem=0;
		s=getFullnameFormat(s);
//		s=getFullnameFormat_v2(s);
		System.out.println(s);
		dem=demSoTuTrongCau(s);
		System.out.println("so tu =" +dem+1);
	}

}
