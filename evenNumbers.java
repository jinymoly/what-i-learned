import java.util.Scanner;

public class EvenNumbers {
    
    public static void main(String[] arg) {
        int answer = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("짝수의 합을 구해드립니다.");
        System.out.println("n의 범위를 지정하세요 ---- 입력 :");
        int n = scanner.nextInt();
        for(int i = 0; i <=n; i++) {
            if(i%2 == 0){
                answer +=i; 
            }
        }
        System.out.println(answer + "입니다.");
        
    }
}
