package programmers.java;

/*
3진법 뒤집기
문제 설명
자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 1 이상 100,000,000 이하인 자연수입니다.
입출력 예
n	result
45	7
125	229
입출력 예 설명
입출력 예 #1

답을 도출하는 과정은 다음과 같습니다.
n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
45	1200	0021	7
따라서 7을 return 해야 합니다.
입출력 예 #2

답을 도출하는 과정은 다음과 같습니다.
n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
125	11122	22111	229
따라서 229를 return 해야 합니다.
 */
public class P_68935 {
    public int solution(int n){
        int answer = 0;
        StringBuilder ternary = new StringBuilder(); // 3진수 
        StringBuilder reverse = new StringBuilder();

        // 3진수 저장
        while (n > 0) {
            int remainder = n % 3; // 나머지
            ternary.append(remainder);
            n /= 3; // 몫 
        }

        // 3진수를 뒤집어
        for(int i = ternary.length() - 1; i >= 0; i--){
            reverse.append(ternary.charAt(i));
        }

        // 10진법으로 표현 
        int power = 1; // 10진수의 자릿수
        for(int i = 0; i < reverse.length(); i++){
            int digit = Character.getNumericValue(reverse.charAt(i)); // 문자를 숫자로
            answer += digit * power; // 현재 자릿수와 곱한 값
            power *= 3; // 다음 자릿수로 이동
        }

        return answer;
    }
}
