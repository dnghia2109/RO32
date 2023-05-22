package Demo_Inclass;

public class ProgramLanTruyen {
	public static void main(String[] args) throws Exception {
		a();
	}

	private static void a() throws Exception {
		// TODO Auto-generated method stub
		b();
	}

	private static void b() throws Exception {
		// TODO Auto-generated method stub
		c();
	}
	private static void c() throws Exception{
		try {
			int x=5/0;

		}catch (ArithmeticException e) {
			System.out.println(" lỗi số học");
		}catch (Exception e) {
			System.out.println("ctrinh có lỗi, liên hệ quản trị");
			System.out.println(e.toString());
		}
		finally {
			System.out.println("goodluck");
		}

	}

	
}
