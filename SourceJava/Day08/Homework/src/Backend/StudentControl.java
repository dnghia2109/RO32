package Backend;

import Entity.Student;

import java.util.*;

public class StudentControl {
    static Scanner sc = new Scanner(System.in);
    // Thêm sinh viên
    public void addStudent(Student s, List<Student> list) {
        list.add(s);
    }

    // In danh sách Student
    public void getAllStudents(List<Student> list) {
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().printData(); // iterator.next(): lấy ra đố tượng tiếp theo.
        }
    }

    //Lấy phẩn tử thứ 4 trong DS sinh viên
    public void getStudentByIndex(List<Student> list) {
        System.out.println("Nhập vị trí muốn tìm kiếm: ");
        int viTri = Integer.parseInt(sc.nextLine());
        if ((viTri < 0) || (viTri > list.size())) {
            System.out.println("Vị trí không phù hợp, chọn vị trí nằm trong khoảng từ 0 - " +list.size());
        } else {
            list.get(viTri).printData();
        }
    }

    // Lấy phần tử đầu và cuối trong DSSV
    public void getFirstAndLastStudent(List<Student> list) {
        if (list.isEmpty()) {
            System.out.println("Không có SV nào trong ds");
        } else {
            System.out.println("SV đầu tiên trong DS: ");
            list.get(0).printData();
            System.out.println("SV cuối cùng trong DS:");
            list.get(list.size() - 1).printData();
        }
    }

    // Thêm sv vào vị trí đầu
    public void addStudentToTopList(List<Student> list) {
        Student newStudent = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("- Nhập tên SV muốn thêm: ");
        newStudent.setName(sc.nextLine());
        list.add(0, newStudent);
    }

    // Thêm sv vào cuối
    public void addStudentToBottomList(List<Student> list) {
        Student newStudent = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("- Nhập tên SV muốn thêm: ");
        newStudent.setName(sc.nextLine());
        list.add(list.size(), newStudent);
    }

    // Đảo ngược ds (Tham khảo ở src sau: https://www.geeksforgeeks.org/java-program-to-reverse-a-list/)
    public void reverseListStudent(List<Student> list) {
        Collections.reverse(list);
    }

    // Tìm sv theo id
    public void findStudentById(List<Student> list, int id) {
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.next().printData(); // iterator.next(): lấy ra đố tượng tiếp theo.
            } else {
                System.out.println("Không tìm thấy Sinh viên có id - " + id);
            }
        }
    }

    // Tìm sv theo name
    public void findStudentByName(List<Student> list, String findName) {
        List<Student> rs = new ArrayList<>();
        for (Student student: list) {
            if (student.getName().equalsIgnoreCase(findName)) {
                //student.printData();
                rs.add(student);
            }
        }
        for (Student student: rs) {
            student.printData();
        }
    }

    // Tìm sv trùng tên
    public List<Student> getStudentDuplicateName(List<Student> list) {
//        List<Student> newList = new ArrayList<>();
//        Collections.copy(newList, list);
        //newList.retainAll();

        List<Student> result = new ArrayList<>();
        for (int i = 0; i <= list.size() ; i++) {
            for (int j = i + 1; j <= list.size() - 1; j++) {
                if (list.get(i).getName().equalsIgnoreCase(list.get(j).getName()) && !result.contains(list.get(i))) {
                    result.add(list.get(i));
                }
            }
        }
        return result;
    }


    // Sắp xếp danh sách theo tên
    public void sortByName(List<Student> list) {
        List<Student> result = new ArrayList<>();
        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        };
        list.sort(comparator);
//        result.addAll(list);
//        getAllStudents(result);

        getAllStudents(list);

    }

    public void sortById(List<Student> list) {
        List<Student> result = new ArrayList<>();
        result.addAll(list);
        Collections.sort(result);
        getAllStudents(result);
    }

    // =================================================================================================================
    // Question 2: Question 2 (Optional): Stack & Queue
    // Khai báo 1 danh sách lưu các tên học sinh tới tham dự phỏng vấn, thứ tự tới của các học sinh như sau:
    // Nguyễn Văn Nam, Nguyễn Văn Huyên, Trần Văn Nam,
    // Nguyễn Văn A
    // a) Tạo 1 method để in ra thứ tự tới của các học sinh theo thứ tự từ
    // muộn nhất tới sớm nhất (gợi ý dùng Stack)
    // b) Tạo 1 method để in ra thứ tự tới của các học sinh theo thứ tự
    // sớm nhất tới muộn nhất (gợi ý dùng Queue)



}
