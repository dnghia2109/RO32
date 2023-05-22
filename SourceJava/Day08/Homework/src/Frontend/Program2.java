package Frontend;



import Backend.DepartmentControl;
import Entity.Department;
import Utils.WorkWithFile;

import java.util.Scanner;

public class Program2 {
    //static Program2 program2 = new Program2();
    static Scanner sc = new Scanner(System.in);

    static Department[] departments;
    static DepartmentControl departmentControl = new DepartmentControl();

    static WorkWithFile workWithFile = new WorkWithFile();
    static String FILE_NAME = "/Users/nghialai/Desktop/VTI/RO32/SourceJava/Day07/example.rtf";
    public static void menu() {
        System.out.println("1. Tạo DS phòng ban");
        System.out.println("2. In DS phòng ban");
        System.out.println("3. Lưu DS vừa tạo ra file");
        System.out.println("4. Lấy DS department từ file ");
        System.out.println("5. ");
        System.out.println("6. ");
        System.out.println("7. ");
        System.out.println("8. ");
        System.out.println("9. Thoát");
    }

    public static void main(String[] args) {
        while (true) {
            menu();
            System.out.println("Chọn các chức năng từ 1-9: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    departments = departmentControl.createDepartment();
                    break;
                case 2:
                    departmentControl.printDepartment(departments);
                    break;
                case 3: // Ghi vào file các department vừa tạo
                    writeObjectFromFile();
                    break;
                case 4: // Đọc dữ liệu các department từ file ra
                    departments = readObjectFromFile();
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Chọn các chức năng từ 1-9 ! ");
            }
        }
    }

    // Đọc dữ liệu các department từ file ra
    private static Department[] readObjectFromFile() {
        return (Department[]) workWithFile.readFromFile(FILE_NAME);
    }

    // Ghi vào file các department trong mảng departments vừa tạo
    private static void writeObjectFromFile() {
        workWithFile.writeToFile(FILE_NAME, departments);
    }


}
