package theStandardOfJava.part_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex15_12 {
    public static void main(String[] args) {
        String line = "";

        try {
            InputStreamReader iStreamReader = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(iStreamReader);

            System.out.println("사용중인 OS의 인코딩 : " + iStreamReader.getEncoding());

            do {
                System.out.println("문장을 입력하세요. 마치시려면 q를 입력하세요.>>");
                line = br.readLine();
                System.out.println("입력하신 문장 : " + line);
            } while (!line.equalsIgnoreCase("q"));
            System.out.println("프로그램을 종료합니다.");
        } catch (IOException exception){}
    }
}