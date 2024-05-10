package theSmallApp;

/**
 * [요구 조건]
 * 시간표 중 요일과 시간을 나누어 요일 + 시간1, 요일 + 시간2 로 바꿔 출력한다.
 * e.g. 월12, 수34 -> 월1, 월2 / 수3, 수4
 * 
 */
public class SeparatingHangeulAndNumbers {
    
    public static void main(String[] args) {
        
        String[] input = {"월12", "수34"};

        for(String element : input) {
            String korean = extractKorean(element);
            String numbers = extractNumber(element);

            String[] numberArr = numbers.split("");
            String result = korean + numberArr[0] + ", " + korean + numberArr[1];

            System.out.println(result);

        }
    }

    /**
     * 한글을 추출한다.
     * @param str
     * @return
     */
    private static String extractKorean(String str){
        StringBuilder koreanPart = new StringBuilder();
        for(char ch : str.toCharArray()) {
            if(Character.isLetter(ch)){
                koreanPart.append(ch);
            }
        }
        return koreanPart.toString();
    } 

    /**
     * 숫자를 추출한다.
     * @param str
     * @return
     */
    private static String extractNumber(String str){
        StringBuilder number = new StringBuilder();
        for(char ch : str.toCharArray()){
            if(Character.isDigit(ch)){
                number.append(ch);
            }
        }

        return number.toString();
    }
}
