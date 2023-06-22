package preTest;

import java.util.Scanner;

/*
 * 앞에서 읽을 때나 뒤에서 읽을 때 같은 문자열 - 팰린드롬
 * 단, 회문을 검사할 때 알파벳만 가지고 회문을 검사하며 대소문자를 구분하지 않는다.
 * 알파벳 이외의 문자는 무시한다.
 */
class Main {
    
    public String solution(String str){
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]","");
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp))
            answer = "YES";

        return answer;

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));


    }
}