package theStandardOfJava.part_02;

import java.util.Comparator;
import java.util.stream.Stream;

/*
 * 문자열 배열 strArr의 문자열 중에서 가장 긴 것의 길이를 출력 
 */
public class Ex14_6e {
    public static void main(String[] args) {
        String[] strArr = { "aaa", "bb", "c", "dddd"};

        Stream<String> stringStream = Stream.of(strArr);
        Stream<Integer> strMap = stringStream.map(s -> s.length());
        Stream<Integer> maxStr = strMap.sorted(Comparator.reverseOrder()).limit(1);
        maxStr.forEach(System.out::println);
        
        // 한 줄로 만들어보자 
        // Stream.of(strArr).map(s -> s.length()).sorted(Comparator.reverseOrder()).limit(1).forEach(System.out::println);
    }
}
