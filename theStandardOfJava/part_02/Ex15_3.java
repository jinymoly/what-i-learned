package theStandardOfJava.part_02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Ex15_3 {
    public static void main(String[] args) {
        byte[] inSource = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSource = null;
        byte[] tmp = new byte[4];

        ByteArrayInputStream input = new ByteArrayInputStream(inSource);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.out.println("input source : " + Arrays.toString(inSource));

        try {
            while(input.available() > 0){
                int len = input.read(tmp);
                output.write(tmp, 0, len);

                outSource = output.toByteArray();
                printArrays(tmp, outSource);
            }
        }
        catch(IOException e) {

        }
    }

    static void printArrays(byte[] tmp, byte[] outSource) {
        System.out.println("tmp : " + Arrays.toString(tmp));
        System.out.println("output source : " + Arrays.toString(outSource));
    }
}
