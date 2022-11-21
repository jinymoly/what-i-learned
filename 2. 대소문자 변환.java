import java.util.Scanner;

class Main {
    
    public String solution(String str) {
        String answer = "";
        for (char x : str.toCharArray()){
            if(Character.isLowerCase(x)) answer +=Character.toUpperCase(x);
            else answer +=Character.toLowerCase(x);
        }
        return answer;
    }

    /*
     * 아스키코드로 풀어보기 8번 라인부터 
     * if (x>=97 && x<=122) : 소문자 아스키 범위 
     * answer += (char)(x-32);
     * else answer += (char)(x+32); 
     */


    
    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}