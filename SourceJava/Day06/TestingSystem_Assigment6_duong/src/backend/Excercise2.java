package backend;

import entity.Department;

public class Excercise2 {
	Department d1=new Department(1,"dev");
	Department d2=new Department(2,"Testing");
	Department d3=new Department(3,"Sale");
	Department[] departments= {d1,d2,d3};
	public String getIndex(int index) {
		String result="";
		try {
			result=departments[index].toString();
		}catch (IndexOutOfBoundsException e) {
			System.out.println("Cannot find department ");
		}catch (Exception e) {
			System.out.println("another error! "+ e.toString());
		}
		return result;
	}
	public void outputDepat() {
		for (Department d:departments)
			System.out.println(d);
	}
}
