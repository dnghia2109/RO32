package Frontend;

import java.io.File;

public class ProgramCheckFile {
    public static void main(String[] args) {
        File file = new File("/Users/nghialai/Desktop/VTI/RO32/SourceJava/Day07/Untitled.txt");
        if (file.exists()) {
            System.out.println("File is exist");
        } else {
            System.out.println("File is not exist");
        }
    }
}
