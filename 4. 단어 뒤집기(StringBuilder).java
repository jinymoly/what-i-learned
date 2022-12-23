import java.util.ArrayList;
import java.util.Scanner;


class Main {
    
    public ArrayList<String> solution(int a, String[] str){
        ArrayList<String> answer = new ArrayList<>();
        for(String x : str){
            char[] s = x.toCharArray();
            int lt = 0;
            int rt = x.length() -1;
            while(lt<rt){
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
            return answer;

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        String[] str = new String[a];

        for(int i = 0; i < a; i++){
            str[i]=kb.next();
        }
        for(String x : T.solution(a, str)){
            System.out.println(x);
        }

    }
}