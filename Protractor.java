import java.util.Scanner;


public class Protractor {
    

    public static void main(String[] args) {
        int answer = 0;

        System.out.println("몇 도 ?");
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextInt();
        
        if(0<answer && answer<90){
            System.out.println("1 예각입니다.");
        } else if(answer ==90){
            System.out.println("2 직각입니다.");
        } else if(90<answer && answer <180){
            System.out.println("3 둔각입니다.");
        } else if(answer== 180){
            System.out.println("4 평각입니다.");
        }
        
    }

    }
