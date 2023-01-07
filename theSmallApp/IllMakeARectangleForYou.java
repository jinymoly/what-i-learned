package theSmallApp;
import java.util.Scanner;
import java.util.stream.IntStream;

public class IllMakeARectangleForYou {
    
    public static void main(String[] args) {
        int row;
        int column;
        Scanner input = new Scanner(System.in);
        
        System.out.print("몇 줄 직사각형 만들래? >>>>> ");
        column = input.nextInt();
        row = column+1;

        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, row).forEach(s-> stringBuilder.append("Yes"));
        IntStream.range(0, column)
            .forEach(s-> System.out.println(stringBuilder.toString()));

    }
}
