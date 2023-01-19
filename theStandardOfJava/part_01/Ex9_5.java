package theStandardOfJava.part_01;

public class Ex9_5 {
    
    public static void main(String[] args) {
        System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)","~!@#$%^&*()"));
        System.out.println("(1 2 3 4\t5)" + " -> " + delChar("(1 2 3 4 \t5)", " \t"));
    }

    public static String delChar(String src, String delCh){

        StringBuffer sb = new StringBuffer(src.length()); // 문자열을 바꿀 수 있음 

        for(int i = 0; i<src.length(); i++) { // 문자열을 순서대로 가져 와 

            char c = src.charAt(i); // i번째 글자가 
            if(delCh.indexOf(c) ==-1) { // delCh 문자열에 포함되지 않았다면 
                sb.append(c);   // 버퍼에 추가 
            }
        }
        return sb.toString(); // 문자열로 리턴 
    }
}
