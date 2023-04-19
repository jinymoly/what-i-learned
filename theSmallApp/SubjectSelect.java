package theSmallApp;

import java.util.Scanner;

public class SubjectSelect {

    public static void main(String[] args) {

        String course[]={"Java","C++","HTML5","컴퓨터구조","안드로이드"};
        int score[] = {95,88,76,62,55};

        while(true){
            System.out.print("과목 선택 >> ");

            Scanner sc = new Scanner(System.in);
            String name = sc.next();

            if(!(name.equals("Java") || name.equals("C++") || name.equals("HTML5") || name.equals("컴퓨터구조") || name.equals("안드로이드"))){
                System.out.println("다시 기회를 줍니다.");
                continue;
            }
                for(int i = 0; i < course.length; i++){
                    if(name.equals(course[i]))
                        System.out.println(name+"의 점수는 "+score[i]); 
                } 
                
                if(name.equals("그만"))
                System.out.println("종료한다.");
                break;
            }
        }

        
    }