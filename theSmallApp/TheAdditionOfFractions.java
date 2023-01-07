package theSmallApp;
/**
 * 첫 번째 분수의 분자와 분모를 뜻하는 denum1, num1, 
 * 두 번째 분수의 분자와 분모를 뜻하는 denum2, num2가 매개변수로 주어집니다. 
 * 두 분수를 더한 값을 기약 분수로 나타냈을 때 
 * 분자와 분모를 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
 */

public class TheAdditionOfFractions {
    public static void main(int denum1, int num1, int denum2, int num2) {
        
        int[] answer = new int[2];

        answer[0] = denum1 * denum2 + num1 * num2; 
        answer[1] = num1 * num2;


    }
}
