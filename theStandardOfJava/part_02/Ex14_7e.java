package theStandardOfJava.part_02;

import java.util.Random;

// 임의의 로또번호(1~45)를 정렬해서 출력 
public class Ex14_7e {
    
    public static void main(String[] args) {
        new Random().ints(1, 46).limit(6).sorted().forEach(System.out::println);
    }
}
