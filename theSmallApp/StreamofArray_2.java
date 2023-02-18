package theSmallApp;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamofArray_2 {
    
    public static void main(String[] args) {
        char[] cha = {'b', 'a', 'g'};
        String[] str = {"d is not dg", "dg is dg", "as"};
        System.out.println(cha); // bag
        System.out.println(Arrays.toString(str)); // [d, dg, as]

        // char[]를 string[]로 변환해서 Stream에 담아보자 
        // 근데 나중에 생각해보니 스트림은 char[]던지 string[]던지 상관없이 같은 방식으로 다룬다 ㅎ 
        // 애초에 이럴 필요가 없었음 근데 한 번 해보고 싶었다 
        // 
        Stream<char[]> streamCharArr = Stream.of(cha);
        Stream<String> streamString = streamCharArr.map(String::valueOf);
        streamString.forEach(System.out::println);
        
        }
}
