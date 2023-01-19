package theStandardOfJava.part_01;
import java.util.StringJoiner;

public class Ex9_9 {
    
    public static void main(String[] args) {
        String animal = "고양이,강아지,토끼,용,이구아나";
        String[] arr = animal.split(",");
        System.out.println(String.join("*", arr));

        StringJoiner sj = new StringJoiner("@", "[", "]");
        for(String s : arr)
        sj.add(s);

        System.out.println(sj.toString());

    }
}
