package Entity;

public class Admin extends User{
    private int expInYear; //(Số năm kinh nghiệm)

    public Admin(int id) {
        super(id);
        this.expInYear = 0;
    }

    public Admin() {
        super();
        this.expInYear = 0;
    }
    public Admin(int id, String fullName, String email, String password, int expInYear) {
        super(id, fullName, email, password);
        this.expInYear = expInYear;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public static void printTitle() {
        User.printTitle();
        System.out.printf("%25s%n", "expInYear");
    }

    @Override
    public void printData() {
        super.printData();
        System.out.printf("%25d%n \n", expInYear);
    }

    @Override
    public String toString() {
        return "Admin{" + super.toString() +
                "expInYear=" + expInYear +
                '}';
    }


}
