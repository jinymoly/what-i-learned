package programmers.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
/*
카운트 업
문제 설명
정수 start와 end가 주어질 때, start부터 end까지의 숫자를 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.

제한사항
0 ≤ start ≤ end ≤ 50
입출력 예
start	end	result
3	10	[3, 4, 5, 6, 7, 8, 9, 10]
입출력 예 설명
입출력 예 #1

3부터 10까지의 숫자들을 담은 리스트 [3, 4, 5, 6, 7, 8, 9, 10]를 return합니다.
 */
public class P_181920 {
    public int[] solution(int start, int end) {
        int[] answer = {};
        List<Integer> nums = new ArrayList<>();
        for(int i = start; i <= end; i++){
            nums.add(i);
            answer = nums.stream().mapToInt(Integer::intValue).toArray();
        }
        return answer;
    }

    public int[] solution2(int start, int end){
            return IntStream.rangeClosed(start, end).toArray();        
    }
}
