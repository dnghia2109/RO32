package org.example.entity;

public class Employee extends User{
    private String proSkill;
    private int projectId;

    public Employee() {
    }

    public Employee(int id, String fullName, String email, String password, String proSkill, int projectId) {
        super(id, fullName, email, password);
        this.proSkill = proSkill;
        this.projectId = projectId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    public static void printTitle() {
        User.printTitle();
        System.out.printf("%25s%25s%n%n", "expInYear", "projectId");
    }

    @Override
    public void printData() {
        super.printData();
        System.out.printf("%25s%25d%n%n \n", proSkill, projectId);
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                "proSkill='" + proSkill + '\'' +
                ", projectId=" + projectId +
                '}';
    }
}
