package org.example.Entity;

public class Department {
    public int id;
    public String name;

    public void printTitle() { //cờ/ độ rộng
        System.out.printf("%7s%15s%n", "DepartmentID", "DepartmentName");
    }

    public void printData() {
        System.out.printf("%7s%15s%n", id, name);
    }

//    @Override
//    public String toString() {
//        return "Department{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
}

