package Entity;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private int id;
    private String name;
    public static int nextID = 1;

    public Student(String name) {
        this.name = name;
        this.id = nextID++;
    }

    public Student(int id) {
        this.id = id;
    }

    public Student() {
        this.id = nextID++;
        this.name = "No name";
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

    public static void printTitle() {
        System.out.printf("%15s%15s", "ID", "FullName");
    }

    public void printData() {
        System.out.printf("%15d%15s \n", id, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.id, o.getId());
    }
}
