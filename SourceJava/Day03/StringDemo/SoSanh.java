package StringDemo;

public class SoSanh {
	public static void main(String[] args) {
		String s1="abc";
		String s2="abc";
		System.out.println("v1: s1:"+ s1 +" s2:"+ s2 + "so sanh equal "+ s1.equals(s2));
		
		System.out.println("v2: s1:"+ s1 +" s2:"+ s2 + "so sanh =="+ (s1==s2));
		
		String s3=new String("abc");
		String s4=new String("abc");
		
		System.out.println("v3: s3:"+ s3 +" s4:"+ s4 + "so sanh equal "+ (s3.equals(s4)));
		System.out.println("v4: s3:"+ s3 +" s4:"+ s4 + " so sanh =="+ (s3==s4));
	}

}
