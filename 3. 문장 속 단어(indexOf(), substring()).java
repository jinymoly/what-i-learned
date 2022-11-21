import java.util.Scanner;


class Main {
    
    public String solution(String str){
        String answer = "";
        int min = Integer.MIN_VALUE;
        String[] arr = str.split("");
        for(String s : arr){
            int length = s.length();
            if(length>min){
                min = length;
                answer = s;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));


    }
}