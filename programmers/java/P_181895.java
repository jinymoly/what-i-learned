package programmers.java;

import java.util.ArrayList;
import java.util.List;

/*
배열 만들기 3

문제 설명
정수 배열 arr와 2개의 구간이 담긴 배열 intervals가 주어집니다.

intervals는 항상 [[a1, b1], [a2, b2]]의 꼴로 주어지며 각 구간은 닫힌 구간입니다. 닫힌 구간은 양 끝값과 그 사이의 값을 모두 포함하는 구간을 의미합니다.

이때 배열 arr의 첫 번째 구간에 해당하는 배열과 두 번째 구간에 해당하는 배열을 앞뒤로 붙여 새로운 배열을 만들어 return 하는 solution 함수를 완성해 주세요.

제한사항
1 ≤ arr의 길이 ≤ 100,000
1 ≤ arr의 원소 < 100
1 ≤ a1 ≤ b1 < arr의 길이
1 ≤ a2 ≤ b2 < arr의 길이
입출력 예
arr	intervals	result
[1, 2, 3, 4, 5]	[[1, 3], [0, 4]]	[2, 3, 4, 1, 2, 3, 4, 5]
입출력 예 설명
입출력 예 #1

첫 번째 구간에 해당하는 배열은 [2, 3, 4] 입니다.
두 번째 구간에 해당하는 배열은 [1, 2, 3, 4, 5] 입니다.
따라서 이 두 배열을 앞뒤로 붙인 배열인 [2, 3, 4, 1, 2, 3, 4, 5]를 return 합니다.
 */

public class P_181895 {
    public int[] solution(int[] arr, int[][] intervals){
        int[] intervalA = extractSubArray(arr, intervals[0][0], intervals[0][1]);
        int[] intervalB = extractSubArray(arr, intervals[1][0], intervals[1][1]);

        int[] answer = connectBackAndForth(intervalA, intervalB);
        return answer;
    }

    // 특정 구간 추출
    private int[] extractSubArray(int[] arr, int start, int end){
        List<Integer> subArr = new ArrayList<>();
        for(int i = start; i <= end; i++){
            subArr.add(arr[i]);
        }
        return subArr.stream().mapToInt(Integer::intValue).toArray();
    }

    // interval 연결
    private int[] connectBackAndForth(int[] arr1, int[] arr2){
        int[] result = new int[arr1.length + arr2.length];
        int index = 0;

        for(int i = 0; i < arr1.length; i++){
            result[index++] = arr1[i];
        }

        for(int i = 0; i < arr2.length; i++){
            result[index++] = arr2[i];
        }
        return result;
    }
}
