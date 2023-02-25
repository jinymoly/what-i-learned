package theStandardOfJava.part_02;

import java.io.*;

public class Ex15_4 {
    
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);

        int data = 0;

        while((data = fis.read()) != -1){
            char c = (char)data;
            System.out.println(c);
        }
    }
}
