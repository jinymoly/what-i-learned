package preTest;
import java.util.Scanner;
/*
 * 3. 문장 속 단어(indexOf(), substring())
 *  substring() - 주어진 위치부터 끝위치 범위에 포함된 문자열 
 */

class Main {
    
    public String solution(String str){
        String answer = "";
        int min = Integer.MIN_VALUE;
        int pos;
        while((pos = str.indexOf(' '))!=-1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if(len>min){
                min = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }
        if(str.length() > min)
            answer = str;        
        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));


    }
}