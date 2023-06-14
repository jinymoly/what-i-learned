package theSmallApp;

import java.util.Scanner;

public class ReverseArrayByStream {
 
}

class Main {
    
    public String solution(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
        
    }

    public static void main(String[] args) {
        Main T = new Main();
        System.out.print("입력하세요 >>> ");
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));


    }
}
