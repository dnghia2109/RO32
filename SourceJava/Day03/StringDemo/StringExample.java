package StringDemo;

public class StringExample {
	public static void main(String[] args) {
		String s="abc";
		String s2="abc cdef";
		//substring (a,x) trả về xâu con từ vị trí a, lấy x ký tự
//		String s3=s2.substring(4,8);
		String s3=""+s2.subSequence(4,8);
		System.out.println(s3);
		
	}
	

}
