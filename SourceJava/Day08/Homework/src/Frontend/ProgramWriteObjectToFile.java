package Frontend;

import Entity.Department;
import Utils.WorkWithFile;

public class ProgramWriteObjectToFile {
    static WorkWithFile workWithFile = new WorkWithFile();
    static String FILE_NAME = "/Users/nghialai/Desktop/VTI/RO32/SourceJava/Day07/example.rtf";

    public static void main(String[] args) {
        System.out.println();
        Department department = new Department();
        department.setName("DEV");
        System.out.println("Department vừa tạo: dep1 \n" + department);
        workWithFile.writeToFile(FILE_NAME, department);
//        System.out.println("Đọc file department2");
        Department department2 = (Department)workWithFile.readFromFile(FILE_NAME);
//        System.out.println(department2);
//        System.out.println(department);
        System.out.println(workWithFile.readFromFile(FILE_NAME));
        System.out.println(department2);
        System.out.println(department.getId());
        System.out.println(department2.getId());
        System.out.println(department.equals(department2));
    }
}
