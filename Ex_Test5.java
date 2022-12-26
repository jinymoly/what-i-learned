import java.util.Scanner;

/*
 * 5. 특정 문자 뒤집기(toCharArray())
 */
class Main {
    public String solution(String str){
        String answer = "";
        char[] st = str.toCharArray();
        int lt = 0;
        int rt = str.length()-1;
        while(lt < rt){
            if(!Character.isAlphabetic(st[lt])) lt++;
            else if(!Character.isAlphabetic(st[rt])) rt--;
            else {
                char tmp = st[lt];
                st[lt] = st[rt];
                st[rt] = tmp;
                lt ++;
                rt --;

            }

        }
        answer = String.valueOf(st);
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner input = new Scanner(System.in);
        String s = input.next();
        System.out.println(T.solution(s));
    }
    
}

