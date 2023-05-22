package Backend;

import Entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Excercise1 {
    List<Student> list = new ArrayList<>();
    public Excercise1() {
        list.add(new Student("Nguyễn Văn A"));
        list.add(new Student("Nguyễn Văn B"));
        list.add(new Student("Nguyễn Văn C"));
        list.add(new Student("Nguyễn Văn D"));
    }

    public List<Student> getList() {
        return list;
    }

    //    List<Student> list = new ArrayList<>();
//    // Question 1:
//    public void initData() {
//        list.add(new Student("Nguyễn Văn A"));
//        list.add(new Student("Nguyễn Văn B"));
//        list.add(new Student("Nguyễn Văn C"));
//        list.add(new Student("Nguyễn Văn D"));
//    }

    public void getAllStudent() {
        Student.college = "Đại học Công nghệ";
        for (Student student:list) {
            System.out.println(student);
        }
    }




}
