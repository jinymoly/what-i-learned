package theStandardOfJava.part_02;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Ex15_10 {
    public static void main(String[] args) {
        String inputData = "바다사자";
        StringReader input = new StringReader(inputData);
        StringWriter output = new StringWriter();

        int data = 0;

        try {
            while((data = input.read()) != -1){
                output.write(data);
            }
        } catch (IOException exception){}

        System.out.println("input data : " + inputData);
        System.out.println("output data : " + output.toString());
    } 
}
