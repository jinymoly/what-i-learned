import java.util.Scanner;

public class MaxValue {
     
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("----- 숫자 5개 입력 해보렴 -----");

        int[] numbers = new int[5];
        
        for(int i=0; i<numbers.length; i++){
            System.out.print("numbers["+ i + "] = ");
            numbers[i] = sc.nextInt();
        }
       sc.close();

       int max = numbers[0];

       for(int i=1; i<numbers.length; i++){
        if(max<numbers[i]) max = numbers[i];
       }
       System.out.println("최댓값은 : " + max + "!!!");
        
    }

}
