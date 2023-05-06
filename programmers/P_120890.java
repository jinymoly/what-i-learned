package programmers;

import java.util.Arrays;

/*
가까운 수
문제 설명
정수 배열 array와 정수 n이 매개변수로 주어질 때, array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ array의 길이 ≤ 100
1 ≤ array의 원소 ≤ 100
1 ≤ n ≤ 100
가장 가까운 수가 여러 개일 경우 더 작은 수를 return 합니다.
입출력 예
array	n	result
[3, 10, 28]	20	28
[10, 11, 12]	13	12
입출력 예 설명
입출력 예 #1

3, 10, 28 중 20과 가장 가까운 수는 28입니다.
입출력 예 #2

10, 11, 12 중 13과 가장 가까운 수는 12입니다.
※ 공지 - 2023년 3월 29일 테스트 케이스가 추가되었습니다. 기존에 제출한 코드가 통과하지 못할 수도 있습니다.
 */
public class P_120890 {
    public int solution(int[] array, int n) {
        int answer = 0;
        int min = Integer.MAX_VALUE; // 정수의 최댓값을 최소값으로 지정 
        Arrays.sort(array);

        for(int i = 0; i < array.length; i++){
            int abs = Math.abs(array[i] - n);
            if(abs < min) { // 절댓값이 최소값보다 작다면 
                min = abs; // 절댓값을 최소값으로 지정
                answer = array[i];
            }
        }
        return answer;
    }
}
