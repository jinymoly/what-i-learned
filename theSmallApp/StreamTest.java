package theSmallApp;

import java.util.Arrays;
import java.util.List;
public class StreamTest {

    /*
     * list를 stream으로 변환 후 조건 걸어보기 
     * 배열로 출력해보자 
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList("lemon", "gimbap", "strawberry", "bolonesa");

        System.out.println("======== 1 ========");
        Object[] strStream1 = list.stream()
                            .filter(x -> x.contains("m")).toArray();
        System.out.println(Arrays.toString(strStream1));
                            
        System.out.println("======== 2 ========");
        Object[] strStream2 = list.stream()
                                    .map(x -> x.substring(0, 2))
                                    .toArray();
        System.out.println(Arrays.toString(strStream2));
        
    }
}
