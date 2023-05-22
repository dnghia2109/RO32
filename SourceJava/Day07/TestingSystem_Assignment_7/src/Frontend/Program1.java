package Frontend;

import Backend.Excercise1;
import Entity.Student;

public class Program1 {
    public static void main(String[] args) {
        Excercise1 excercise1 = new Excercise1();

        // Question 1:
        int soSV = excercise1.getList().size();
        System.out.println(soSV);
        excercise1.getAllStudent();

        // Question 2:
        Student.moneyGroup = soSV * 100000;
        System.out.println("Tổng quỹ ban đầu: " + Student.moneyGroup);
        System.out.println("Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan \n ==> Quỹ còn lại:  " + (Student.moneyGroup -= 50000));
        System.out.println("Student thứ 2 lấy 20k đi mua bánh mì \n ==> Quỹ còn lại: " + (Student.moneyGroup -= 20000));
        System.out.println("Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm \n ==> Quỹ còn lại: " + (Student.moneyGroup -= 150000));
        System.out.println("cả nhóm mỗi người lại đóng quỹ mỗi người 50k \n ==> Quỹ còn lại: " + (Student.moneyGroup += 50000*soSV));


    }
}
