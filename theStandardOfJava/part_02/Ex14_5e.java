package theStandardOfJava.part_02;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex14_5e {
    
    public static void main(String[] args) {
        String[] strArr = { "aaa", "bb", "c", "dddd"};

        int sum = Stream.of(strArr).mapToInt(s -> s.length()).sum();
        System.out.println(sum);


        // string[]을 intStream으로 변환 
        // 왜ㅑ? IntStream에는 sum(), average() 등 연산 메서드가 있기 때문
        // Stream<String> stringStream = Stream.of(strArr);
        // IntStream mapToInt = stringStream.mapToInt(s -> s.length());
        // int sum = mapToInt.sum();

        // System.out.println(sum);
        
    }
}
