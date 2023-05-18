package theSmallApp;

import java.util.Scanner;

public class FirstLetter {
    public static void main(String[] args) {

        System.out.print("문장을 입력하세요 >>> ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArr = str.split("\\s");
        String answer = "";

        for(String s : strArr){
            String capitalize = capitalizeFirstLetter(s);
            answer += capitalize + " ";
        }

        System.out.println(answer);

    }

    static String capitalizeFirstLetter(String str){
        String firstLetter = str.substring(0,1);
        String remainLetter = str.substring(1); // 첫번째 글자[0] 제외한 나머지 글자들
        
        firstLetter = firstLetter.toUpperCase();
        remainLetter = remainLetter.toLowerCase();
        String result = firstLetter + remainLetter;

        return result;
    }
}
