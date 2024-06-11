package leetCode.java;

/**
1052. Grumpy Bookstore Owner

There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store. You are given an integer array customers of length n where customers[i] is the number of the customer that enters the store at the start of the ith minute and all those customers leave after the end of that minute.

On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.

When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.

The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, but can only use it once.

Return the maximum number of customers that can be satisfied throughout the day.

 

Example 1:

Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
Output: 16
Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes. 
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
Example 2:

Input: customers = [1], grumpy = [0], minutes = 1
Output: 1
 

Constraints:

n == customers.length == grumpy.length
1 <= minutes <= n <= 2 * 104
0 <= customers[i] <= 1000
grumpy[i] is either 0 or 1.

[슬라이딩 윈도우]
고정 사이즈의 윈도우가 이동하면서 윈도우 내에 있는 데이터를 이용해 문제를 풀이하는 알고리즘
배열이나 리스트의 요소의 일정 범위의 값을 비교

e.g. 구간 합 구하기, 부분 문자열 구하기

 */
public class L_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int customer = customers.length;
        int totalSatisfied = 0; 

        for(int i = 0; i < customer; i++){
            if(grumpy[i] == 0){ // 서점 주인이 심술 부리지 않으면 
                totalSatisfied += customers[i]; // 초기, 비밀 기술 없이 만족한 고객을 증가 
            }
        }
        
        int maxSatisfied = 0; // 비밀 기술 사용 시 최대로 만족할 수 있는 고객 수 
        int currentSatisfied = 0;  // 현재 슬라이딩 윈도우 내 추가로 만족 고객 수 

        for(int i = 0; i < minutes; i++){ // 슬라이딩 윈도우 - 첫 minutes 구간 만족 고객 수 계산 
            if(grumpy[i] == 1){ // 심술 on 
                currentSatisfied += customers[i]; // 비밀 기술 적용이므로 불만족이어도 만족으로 침
            }
        }
        maxSatisfied = currentSatisfied;
        
        for(int i = minutes; i < customer; i++){ // 슬라이딩 윈도우 - 나머지 구간 만족 고객 수 계산
            if(grumpy[i] == 1){ // 심술 on
                currentSatisfied += customers[i]; // 비밀 기술 적용이므로 불만족이어도 만족으로 침
            }
            if(grumpy[i - minutes] == 1){ // 윈도우에서 벗어난 시간에 서점 주인이 심술 on
                currentSatisfied -= customers[i - minutes]; // 이 때는 불만족으로 침 
            }
            maxSatisfied = Math.max(maxSatisfied, currentSatisfied); // 현재 슬라이딩 윈도우 에서 추가 만족 고객 수 vs 기존 최대값
        }
        return totalSatisfied + maxSatisfied; // 걍 만족 + 비밀 기술 사용 시 만족한 최대 고객 수 
    }
}
