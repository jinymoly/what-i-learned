package preTest;

import java.util.Scanner;

/*
 *  회문 문자열 
 *  - 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES" 아니면 "NO"를 출력
 *  - 단 회문을 검사할 때 대소문자를 구분하지 않는다.
 * 
 *  g o u o G 일 때 
 *  -> 글자 길이 / 중간이 되는 글자 바로 앞 자리 
 */
class Main {
    
    public String solution(String str){
        String answer = "YES";
        int len = str.length();
        str = str.toLowerCase(); 

        for(int i = 0; i<len/2; i++) {
            if(str.charAt(i) != str.charAt(len-i-1))
            return "NO";
        }
        
            return answer;

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));


    }
}