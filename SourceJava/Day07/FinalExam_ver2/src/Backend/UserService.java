package Backend;

import Entity.Admin;
import Entity.Employee;
import Entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    //static List<User> list = new ArrayList<>();
    // Question 1: Khởi tạo thông tin của các User ở database.
    public List<User> initData() {
        List<User> list = new ArrayList<>();
        list.add(new Employee(2, "Employee 2", "emp2@gmail.com", "123", "Java"));
        list.add(new Employee(3, "Employee 3", "emp3@gmail.com", "123", "Java"));
        list.add(new Employee(4, "Employee 4", "emp4@gmail.com", "123", "Java"));

        list.add(new Admin(1, "Admin 1", "admin1@gmail.com", "123", 6));
        list.add(new Admin(5, "Admin 5", "admin5@gmail.com", "123", 6));
        list.add(new Admin(6, "Admin 6", "admin6@gmail.com", "123", 6));
        return list;
    }

    // Question 2: Viết function để in ra thông tin id và fullName, Email của tất cả User (in ra dạng table)
//    public void printTitle(List<User> list) {
//        System.out.printf("%15s%15s%20s\n", "ID", "FullName", "Email");
//        for (User user: list) {
//            user.printData();
//        }
//    }

    // In kiểu phân loại
    public void printTitle2(List<User> list) {
        System.out.println("--- Users are admin ---");
        for (User user: list) {
            if (user instanceof Admin) {
                user.printData();
                //System.out.println(user);
            }
        }

        System.out.println("--- Users are admin ---");
        for (User user: list) {
            if (user instanceof Employee) {
                user.printData();
                //System.out.println(user);
            }
        }
    }


    // Question 3: Viết function có đầu vào là id của User, sau đó in ra thông tin của User đó
    // Cách 1: sử dụng contains như trên lớp
    public void findUserById(List<User> list, int id) {
        // Cách 1: sử dụng contains như trên lớp
        User userFind = null;
        System.out.println("Select 1 - Admin, 2 - Employee");
        Scanner sc = new Scanner(System.in);
        int option = Integer.parseInt(sc.nextLine());

        if (option == 1) {
            userFind = new Admin();
        } else {
            userFind = new Employee();
        }
        if (list.contains(userFind)) {
            System.out.println("Có tìm thấy user");
        } else {
            System.out.println("Không tìm thấy user");
        }

        for (User user: list) {

        }
    }

}
