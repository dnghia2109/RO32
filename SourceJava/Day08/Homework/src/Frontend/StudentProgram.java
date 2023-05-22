package Frontend;

import Backend.StudentControl;
import Entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentProgram {
    static StudentControl studentControl = new StudentControl();
    static List<Student> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void initData() {
        list.add(new Student("Nghĩa"));
        list.add(new Student("A"));
        list.add(new Student("B"));
        list.add(new Student("Nghĩa"));
        list.add(new Student("A"));
        list.add(new Student("Nghĩa"));

    }
    public static void menu() {
        System.out.println("===== Menu =====");
        System.out.println("\t1: Hiển thị tổng số sv");
        System.out.println("\t2: Lấy SV theo vị trí trong DS.");
        System.out.println("\t3: in phần tử đầu và cuối");
        System.out.println("\t4: Thêm sv vào vị trí đầu");
        System.out.println("\t5: Thêm sv vào cuối");
        System.out.println("\t6: Đảo ngược ds");
        System.out.println("\t7: Tìm sv theo id ");
        System.out.println("\t8: Tìm sv theo name");
        System.out.println("\t9: Tìm sv trùng tên ");
        System.out.println("\t10:xóa tên sv có id=2 ");
        System.out.println("\t11:Xóa sv có id=5");
        System.out.println("\t12:Tạo bản sao ds ");
        System.out.println("\t13:in Danh sách ");
        System.out.println("\t0: exit");
        System.out.print("Lựa chon là:");
    }

    public static void main(String[] args) {
        initData();
        while (true) {
            menu();
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    System.out.println("Tổng số sinh viên trong DS: " + list.size());
                    break;
                case 2:
                    studentControl.getStudentByIndex(list);
                    break;
                case 3:
                    studentControl.getFirstAndLastStudent(list);
                    break;
                case 4:
                    studentControl.addStudentToTopList(list);
                    break;
                case 5:
                    studentControl.addStudentToBottomList(list);
                    break;
                case 6:
                    studentControl.reverseListStudent(list);
                    studentControl.getAllStudents(list);
                case 7:
                    System.out.println("Nhập tên cần tìm: ");
                    int findID = Integer.parseInt(sc.nextLine());
                    studentControl.findStudentById(list, findID);
                case 8:
                    System.out.println("Nhập tên cần tìm: ");
                    String findName = sc.nextLine();
                    studentControl.findStudentByName(list, findName);
                case 9:
                    studentControl.getAllStudents(studentControl.getStudentDuplicateName(list));
                    break;
                case 15:
                    studentControl.sortByName(list);
                    break;
                case 16:
                    studentControl.sortById(list);
                    break;
                case 13:
                    System.out.println("Danh sách SV: ");
                    studentControl.getAllStudents(list);
                    break;
            }
        }
    }
}
