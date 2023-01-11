package theStandardOfJava;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex9_6 {
    
    public static void main(String[] args) {
        String[] phoneNumArr = {
            "012-3456-7890",
            "099-2456-7890",
            "088-2346-9870",
            "013-3456-7890"
        };

        ArrayList list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("번호를 입력하세요.");
            System.out.println(">>");
            String input = sc.nextLine().trim();

            if(input.equals("")){
                continue;
            } else if(input.equalsIgnoreCase("Q")){
                System.out.println("종료합니다.");
                System.exit(0);
            }

            String pattern = ".*" +input+ ".*";
            Pattern p = Pattern.compile(pattern);

            for(int i = 0; i<phoneNumArr.length; i++){
                String pNum = phoneNumArr[i];
                String tmp = pNum.replace("-", "");
                Matcher m = p.matcher(tmp);
                if(m.find()){
                    list.add(pNum);
                }
            }

            if(list.size() > 0) {
                System.out.println(list);
                list.clear();
            } else {
                System.out.println("일치하는 번호가 없습니다.");
            }

            
        }
    }
}
