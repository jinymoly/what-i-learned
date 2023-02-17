package theStandardOfJava.part_02;

import java.util.Arrays;
import java.util.stream.Stream;

// stream은 일회용이므로 한 번 쓸 때마다 다시 생성 해야함 
public class Ex14_7 {
    public static void main(String[] args) {
        Stream<String[]> strArrStream = Stream.of(
            new String[]{"abc", "def", "jkl"},
            new String[]{"ABC", "DEF", "JKL"}
        );

        Stream<String> strStream = strArrStream.flatMap(Arrays::stream);

        strStream.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println("==========");

        String[] lineArr = {
            "Believe or not It is true",
            "Do or do not There is no try",
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        lineStream.flatMap(line -> Stream.of(line.split(" +")))
                .map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println("=====");
    }
}
