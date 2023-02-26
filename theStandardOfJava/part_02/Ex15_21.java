package theStandardOfJava.part_02;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Ex15_21 {
    public static void main(String[] args) {
        try {
            String fileName = "Ex15_19.ser";
            FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);

            ObjectInputStream in = new ObjectInputStream(bis);

            //객체 역직렬화 - 직렬화 할 때의 순서와 일치해야한다.
            Ex15_19 u1 = (Ex15_19)in.readObject();
            Ex15_19 u2 = (Ex15_19)in.readObject();
            ArrayList list = (ArrayList) in.readObject();

            System.out.println(u1);
            System.out.println(u2);
            System.out.println(list);
            in.close();

        } catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
