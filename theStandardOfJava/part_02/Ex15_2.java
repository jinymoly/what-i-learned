package theStandardOfJava.part_02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Ex15_2 {
    public static void main(String[] args) {
        byte[] inSource = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSource = null;
        byte[] tmp = new byte[10];

        ByteArrayInputStream input = new ByteArrayInputStream(inSource);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        input.readNBytes(tmp, 0, tmp.length);
        output.write(tmp, 6, 2);   //tmp

        outSource = output.toByteArray();

        System.out.println("input source : " + Arrays.toString(inSource));
        System.out.println("tmp : " + Arrays.toString(tmp));
        System.out.println("output source : " + Arrays.toString(outSource));
    }
}
