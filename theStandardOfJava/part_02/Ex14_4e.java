package theStandardOfJava.part_02;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * 두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우를 모두 출력 
 * [1, 5]
 * [2, 4]
 * [3, 3]
 * [4, 2]
 * [5, 1] 
 */
public class Ex14_4e {
    public static void main(String[] args) {
        Stream<Integer> dice = IntStream.rangeClosed(1, 6).boxed();

        dice.flatMap(i -> Stream.of(1,2,3,4,5,6)
                        .map(i2 -> new int[]{i, i2}))
            .filter(iArr -> iArr[0] + iArr[1] == 6)
            .forEach(iArr -> System.out.println(Arrays.toString(iArr)));
    }
}
