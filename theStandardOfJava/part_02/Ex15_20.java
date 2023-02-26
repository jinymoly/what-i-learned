package theStandardOfJava.part_02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ex15_20 {
    public static void main(String[] args) {
        try {
            String fileName = "Ex15_19.ser";
            FileOutputStream fos = new FileOutputStream(fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            ObjectOutputStream out = new ObjectOutputStream(bos);

            Ex15_19 u1 = new Ex15_19("javaman", "1234", 0);
            Ex15_19 u2 = new Ex15_19("superman", "4321", 0);

            ArrayList<Ex15_19> list = new ArrayList<>();
            list.add(u1);
            list.add(u2);

            // 객체 직렬화
            out.writeObject(u1);
            out.writeObject(u2);
            out.writeObject(list);
            out.close();
            System.out.println("직렬화가 잘 끝났다.");
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
