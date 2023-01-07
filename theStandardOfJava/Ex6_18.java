package theStandardOfJava;
public class Ex6_18 {
    
    public static boolean isNumber(String str){
        boolean result = true;
        
        for(int i = 0; i<str.length(); i++){
            if(!(str.charAt(i)>='0' && str.charAt(i)<='9')){
                result = false;
            }
        }
        return result;
    }
    
    
    public static void main(String[] args) {
        String str = "1234";
        System.out.println(str + "는 숫자입니까? " + isNumber(str));

        str = "1234oiu";
        System.out.println(str + "는 숫자입니까? " + isNumber(str));
    }
}
