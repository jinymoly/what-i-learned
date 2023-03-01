package programmers;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/*
짝수는 싫어요
문제 설명
정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ n ≤ 100
입출력 예
n	result
10	[1, 3, 5, 7, 9]
15	[1, 3, 5, 7, 9, 11, 13, 15]
입출력 예 설명
입출력 #1

10 이하의 홀수가 담긴 배열 [1, 3, 5, 7, 9]를 return합니다.
입출력 #1

15 이하의 홀수가 담긴 배열 [1, 3, 5, 7, 9, 11, 13, 15]를 return합니다.
 */
public class P_12813 {
    public int[] solution(int n) {
        ArrayList<Integer> nList = new ArrayList<Integer>();
                
        for(int i = 1; i <=n; i+=2){
            nList.add(i);
        }
        // list -> int[] 변환 
        int[] array = nList.stream().mapToInt(Integer::intValue).toArray();
            return array;
        
    }
}