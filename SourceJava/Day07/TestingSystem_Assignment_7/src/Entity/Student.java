package Entity;

public class Student {
    private int id;
    private String name;

    static int nextID = 1;
    public static String college = "Đại học bách khoa";
    public static double moneyGroup = 0;
    //public static int COUNT = 0;

    public Student() {
        this.id = nextID++;
    }

    public Student(String name) {
        this.id = nextID++;
        this.name = name;
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

    public String getCollege() {
        return Student.college;
    }

    public void setCollege(String college) {
        Student.college = college;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' + ", Đại học= " + college +
                '}';
    }
}
