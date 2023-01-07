package theSmallApp;
import java.util.Scanner;

// 피라미드 만들기 
public class NewPyramidApp {
    public static void main(String[] args) {
        int line;
        Scanner scanner = new Scanner(System.in);

        System.out.print("피라미드 몇 층 만들래? >>>> ");
        line = scanner.nextInt();

        for(int i=line, add=0; i>0; i--, add++){
            for (int j=0; j<i; j++){
                System.out.print(" ");
            } 
            for (int j=0; j<line-(i-1)+add; j++){
                System.out.print("&");
            }
            
            System.out.println();
        }
    }
}
