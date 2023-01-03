import java.util.Arrays;

public class Ex6_17 {
    
    public static int[] shuffle(int[] arr){
        for(int i = 0; i<arr.length; i++){
            int n = (int)(Math.random()*arr.length);

            int tmp = arr[n];
            arr[n] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] orginal = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(orginal));

        int[] result = shuffle(orginal);
        System.out.println(Arrays.toString(result));
    }
}
