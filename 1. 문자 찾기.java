import java.util.Scanner;
  
class Main {

  public String solution(String str) {
    String answer = "";
    for(char x : str.toCharArray()) {
      if(Character.isLowerCase(x))
        answer += Character.toUpperCase(x);
      else
        answer += Character.toLowerCase(x);
    }
    return answer;
}
  
  public static void main(String[] args){
  	Main T = new Main();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(T.solution(str));
  }
}