package theStandardOfJava.part_02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Ex15_1 {
    public static void main(String[] args) {
        byte[] inSource = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSource = null;

        ByteArrayInputStream input = new ByteArrayInputStream(inSource);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int data = 0;

        while((data = input.read()) != -1) 
            output.write(data);

        outSource = output.toByteArray(); // 스트림의 내용을 byte배열로 반환 

        System.out.println("input source : " + Arrays.toString(inSource));
        System.out.println("output source : " + Arrays.toString(outSource));
    }
}
