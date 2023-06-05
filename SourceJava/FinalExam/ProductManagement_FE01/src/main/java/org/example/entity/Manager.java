package org.example.entity;

public class Manager extends User{
    private int expInYear;
    private int projectId;

    public Manager(int id, String fullName, String email, String password, int expInYear, int projectId) {
        super(id, fullName, email, password);
        this.expInYear = expInYear;
        this.projectId = projectId;
    }

    public Manager() {
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public static void printTitle() {
        User.printTitle();
        System.out.printf("%25s%25s%n%n", "expInYear", "projectId");
    }

    @Override
    public void printData() {
        super.printData();
        System.out.printf("%25d%25d%n%n \n", expInYear, projectId);
    }

    @Override
    public String toString() {
        return "Manager{" + super.toString()+
                "expInYear=" + expInYear +
                ", projectId=" + projectId +
                '}';
    }
}
