package Entity;

public class PrimaryStudent extends Student{
    public static int countPrimaryStu = 0;

    public PrimaryStudent() {
        super();
        countPrimaryStu++;
    }
}
