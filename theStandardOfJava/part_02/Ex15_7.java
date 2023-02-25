package theStandardOfJava.part_02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Vector;

public class Ex15_7 {
    public static void main(String[] args) {
        byte[] arr1 = {0, 1, 2};
        byte[] arr2 = {3, 4, 5};
        byte[] arr3 = {6, 7, 8};
        byte[] outSource = null;

        Vector v = new Vector();
        v.add(new ByteArrayInputStream(arr1));
        v.add(new ByteArrayInputStream(arr2));
        v.add(new ByteArrayInputStream(arr3));

        SequenceInputStream input = new SequenceInputStream(v.elements());
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int data = 0;

        try {
            while((data = input.read()) != -1){
                output.write(data);
            }

        } catch (IOException e) {}

        outSource = output.toByteArray();

        System.out.println("input source1 : " + Arrays.toString(arr1));
        System.out.println("input source2 : " + Arrays.toString(arr2));
        System.out.println("input source3 : " + Arrays.toString(arr3));
        System.out.println("output source : " + Arrays.toString(outSource));
    }
}
