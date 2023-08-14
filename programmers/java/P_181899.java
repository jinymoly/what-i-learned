package programmers.java;

import java.util.stream.IntStream;

/*
카운트 다운
문제 설명
정수 start와 end가 주어질 때, start에서 end까지 1씩 감소하는 수들을 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.

제한사항
0 ≤ end ≤ start ≤ 50
입출력 예
start	end	result
10	3	[10, 9, 8, 7, 6, 5, 4, 3]
입출력 예 설명
입출력 예 #1

10부터 3까지 1씩 감소하는 수를 담은 리스트는 [10, 9, 8, 7, 6, 5, 4, 3]입니다.
 */
public class P_181899 {
    public int[] solution(int start, int end){
        int size = start - end + 1;
        int[] answer = new int[size];

        for(int i = 0; i < size; i++){
            answer[i] = start - i;
        }
        return answer;
    }

    //Lambda로 풀어보기
    public int[] solution2(int start, int end){
        int size = start - end + 1;

        return IntStream.iterate(start, i -> i - 1)
                        .limit(size)
                        .toArray();
    }

    // Lambda로 더 간단하게 리팩토링 
    public int[] solution3(int start, int end){
        return IntStream.rangeClosed(end, start)
                        .map(i -> start - end + 1)
                        .toArray();
    }
}
