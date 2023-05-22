package entity;
//talbe1: Department
public class Department {
	int departmentID; //định danh của phòng ban
	String departmentName; //tên đầy đủ của phòng ban (VD: sale, marketing, …) 
	
	public Department(int departmentID, String departmentName) {
		
		this.departmentID = departmentID;
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [ID=" + departmentID + ", Name=" + departmentName + "]";
	}


}
