import java.util.Scanner;

public class MaxValue {
     
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 5개 입력하세요 : >>>>> ");
        int[] numbers = new int[5];
        
        
        for(int i=0; i<=5;i++){
            numbers[i] = sc.nextInt();
            System.out.println("num[" + i + "]");
        }
        sc.close();

        
    }

    
}
