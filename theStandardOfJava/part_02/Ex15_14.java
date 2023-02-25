package theStandardOfJava.part_02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Ex15_14 {
    public static void main(String[] args) {
        PrintStream ps = null;
        FileOutputStream foutStream = null;

        try {
            foutStream = new FileOutputStream("test.txt");
            ps = new PrintStream(foutStream);
            System.setOut(ps);
        } catch (FileNotFoundException exception) {
            System.err.println("File not found.");
        }

        System.out.println("Hello by System.out");
        System.err.println("Hello by System.err");
    }
}
