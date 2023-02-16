package theSmallApp;

/*
 * how to create a stream of an array ~ 
 * + 가변인자 사용하기; use variable argument
 */
public class StreamOfArray {
    public static void main(String[] args) {
        int sum = add(1,2,3,4,5);
        System.out.println("add() : " + sum);

        sum = addString("lemon", 7,8,9);
        System.out.println("addString() : " + sum);

    }

    static int add(int...nums) {
        int answer = 0;
        for(int num : nums){
          answer += num;
        }
        return answer;
    }

    static int addString(String s, int...num){
        int answer = 0;
        System.out.println(s);

        for(int i =0; i<num.length; i++){
            answer = answer + num[i];
        }
        return answer;
    }
}

