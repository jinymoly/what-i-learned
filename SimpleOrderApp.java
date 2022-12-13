import java.util.Scanner;

public class SimpleOrderApp {

    public static void main(String[] args) {
        
        int menu = 0;
        int count = 0;
        
        outer:
        while(true){
            System.out.println("1번 바나나");
            System.out.println("2번 사과");
            System.out.println("3번 레몬");
            System.out.println("4번 수박");
            System.out.println("메뉴를 선택하세요. ----- 메뉴 번호 입력 : ");

            Scanner scanner = new Scanner(System.in);
            String tmp = scanner.nextLine();
            menu = Integer.parseInt(tmp);

            if(menu == 0){
                System.out.println("주문을 종료합니다.");
                break;
            } else if(!(1 <= menu && menu <= 4)){
                System.out.println("메뉴를 잘 못 입력했으니 다시 입력하세요.");
                continue;
            }

            for(;;){
                System.out.println("주문서 작성하기 (메뉴로 돌아가기: 0번) ------ 주문 개수 입력 : ");
                tmp = scanner.nextLine();
                count = Integer.parseInt(tmp);

                if(count == 0)
                    break;
                    
                 if(count == 99)
                    break outer;

                    switch(menu){
                        case 1 :
                        System.out.println("1번 바나나를 " + count + "개 주문! ");
                        break;

                        case 2 :
                        System.out.println("2번 사과를 " + count + "개 주문! ");
                        break;

                        case 3 : 
                        System.out.println("3번 레몬을 " + count + "개 주문! ");
                        break;

                        case 4 : 
                        System.out.println("4번 수박을 " + count + "개 주문! ");
                        break;
                    }
                }
            }

        
    }
    
}
