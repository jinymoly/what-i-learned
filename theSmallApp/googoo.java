package theSmallApp;

import java.util.Scanner;

public class googoo {
    public static void main(String[] args) {

        System.out.println(" 몇 단 만들어줄까? ");
        Scanner sc = new Scanner(System.in);
        int dan = sc.nextInt();

        System.out.println("=====================");
        System.out.println(dan + "단 입니다.");
        for(int i = 1; i <= 1; i++){
            for( int j = 1; j <= 9; j++){
                System.out.println(dan + " * " + j + " = " + dan*j);
            }
            System.out.println("=====================");
        }
    }
}
