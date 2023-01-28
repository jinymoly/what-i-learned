package preTest;

import java.util.Scanner;

/*
 * 주어진 문자의 최소 거리 구하기 
 */

class Main {
    
    public int[] solution(String str, char t){
            int[] answer = new int[str.length()];
            int p = 1000;
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == t){
                    p = 0;
                    answer[i] = p;

                } else {
                    p ++;
                    answer[i] = p;
                }
            }        
            p = 1000;
            for(int i = str.length() -1; i >=0; i--) {
                if(str.charAt(i) == t) 
                p = 0;
                else {
                    p ++;
                    answer[i] = Math.min(answer[i], p);
                }
            }
            return answer;

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        
        for(int x : T.solution(str, c)){
            System.out.print(x + " ");
        }


    }
}

