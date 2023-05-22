package Entity;

import java.io.Serializable;

public class Department implements Serializable {
    private int id;
    private String name;
    public static int nextID = 1;

    public Department() {
        this.id = nextID++;
    }

    public static void printTitle() { //cờ/ độ rộng
        System.out.printf("%7s%15s%n", "DepartmentID", "DepartmentName");
    }

    public void printData() {
        System.out.printf("%7s%15s%n \n", id, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    @Override
//    public String toString() {
//        return "Department{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
}

