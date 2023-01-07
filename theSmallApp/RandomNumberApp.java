package theSmallApp;
import java.util.Scanner;

public class RandomNumberApp {
    
    public static void main(String[] args) {

        int input = 0;
        int random = 0;

        System.out.println("숫자를 입력하세요 >>>>>");
        Scanner scanner = new Scanner(System.in);

        random = (int) (Math.random()*100) + 1;

        do {
            input = scanner.nextInt();

            if(input >random) {
                System.out.println("더 작은 숫자를 입력해 봐 >>>>");

            } else if(input <random) {
                System.out.println("더 큰 숫자를 입력해 봐 >>>>>>");

            }
        }
        while (input !=random);

        System.out.println("오 정답 !!!! ");
        
    }
}
