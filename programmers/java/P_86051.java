package programmers.java;

import java.util.HashSet;

/*
없는 숫자 더하기
문제 설명
0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다. numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ numbers의 길이 ≤ 9
0 ≤ numbers의 모든 원소 ≤ 9
numbers의 모든 원소는 서로 다릅니다.
입출력 예
numbers	result
[1,2,3,4,6,7,8,0]	14
[5,8,4,0,6,7,9]	6
입출력 예 설명
입출력 예 #1

5, 9가 numbers에 없으므로, 5 + 9 = 14를 return 해야 합니다.
입출력 예 #2

1, 2, 3이 numbers에 없으므로, 1 + 2 + 3 = 6을 return 해야 합니다.
 */
public class P_86051 {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] present = new boolean[10];
        
        for(int num : numbers){
            present[num] = true;
        }

        for(int i = 0; i <present.length; i++){
            if(!present[i]){
                answer += i;
            }
        }

        return answer;
    }

    // 중복 없이 저장하는 HashSet에 담아
    public int solution2(int[] numbers){
        int answer = 0;
        HashSet<Integer> numSet = new HashSet<>();

        for(int num : numbers){
            numSet.add(num);
        }

        for(int i = 0; i <=9; i++){
            if(!numSet.contains(i))
            answer += i;
        }
        return answer;

    }
    
}
