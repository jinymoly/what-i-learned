package programmers.java;

import java.util.Scanner;

public class P_181944 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n + " is" + (n % 2 == 0 ? " even" : " odd"));
    }
}
