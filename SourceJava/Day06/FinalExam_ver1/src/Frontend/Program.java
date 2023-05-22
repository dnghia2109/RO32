package Frontend;

import Backend.UserService;
import Entity.Admin;
import Entity.Employee;

public class Program {
    public static void main(String[] args) {
//        Admin admin = new Admin(1, "Admin 1", "admin1@gmail.com", "123", 6);
//        Admin.printTitle();
//        admin.printData();
//        System.out.println(admin);
//
//
//        Employee employee = new Employee(2, "Employee 2", "emp2@gmail.com", "123", "Java");
//        System.out.println(employee);


        UserService userService = new UserService();
        //userService.initData();
        userService.printTitle2(userService.initData());
    }
}
