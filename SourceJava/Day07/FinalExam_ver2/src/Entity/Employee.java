package Entity;

public class Employee extends User{
    private String proSkill; // các kỹ năng
    public Employee(int id, String fullName, String email, String password, String proSkill) {
        super(id, fullName, email, password);
        this.proSkill = proSkill;
    }

    public Employee() {
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    public static void printTitle() {
        User.printTitle();

    }

    @Override
    public void printData() {
        super.printData();
        System.out.printf("%25s%n \n", proSkill);
    }


    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                "proSkill='" + proSkill + '\'' +
                '}';
    }
}
