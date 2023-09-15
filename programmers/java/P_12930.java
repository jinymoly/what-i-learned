package programmers.java;
/*
이상한 문자 만들기
문제 설명
문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

제한 사항
문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
입출력 예
s	return
"try hello world"	"TrY HeLlO WoRlD"
입출력 예 설명
"try hello world"는 세 단어 "try", "hello", "world"로 구성되어 있습니다. 각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 "TrY", "HeLlO", "WoRlD"입니다. 따라서 "TrY HeLlO WoRlD" 를 리턴합니다.
 */
public class P_12930 {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split(" ", -1); // 공백 기준으로 문자열 자르되 마지막 빈 문자열도 포함

        for(int i = 0; i < words.length; i++){
            String[] word = words[i].split("");
            for(int j = 0; j < word.length; j++){
                if(j % 2 == 0){
                    word[j] = word[j].toUpperCase(); // 원본 문자열을 변경하지 않는 메서드이므로 문자열을 다시 해당 변수에 저장해야함
                } else {
                    word[j] = word[j].toLowerCase(); // 원본 문자열을 변경하지 않는 메서드이므로 문자열을 다시 해당 변수에 저장해야함
                }
            }
            words[i] = String.join("", word); // 단어 내 문자열 합침 
        }
        answer = String.join(" ", words); // 그 단어에 공백을 넣어 문자열로 합침
        return answer;
    }
}
