package programmers.java;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
문자열 내림차순으로 배치하기
문제 설명
문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

제한 사항
str은 길이 1 이상인 문자열입니다.
입출력 예
s	return
"Zbcdefg"	"gfedcbZ"
 */
public class P_12197 {
    public String solution(String s) {
        String answer = "";
        
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        
        for(int i = 0; i < chars.length / 2; i++){
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 -i ];
            chars[chars.length - 1 - i] = temp;
        }
        answer = new String(chars);
        return answer;
    }

    // 이게 속도가 느리긴 하네 
    public String solutionStream(String s){
        String answer = Stream.of(s.split("")) // 문자열을 문자 배열로 분할
                                .filter(c -> Character.isLetter(c.charAt(0))) // 문자만 선택
                                .sorted((a, b) -> b.compareTo(a)) // 내림차순 
                                .collect(Collectors.joining()); // 문자열 합치기

        return answer;
    }
}
