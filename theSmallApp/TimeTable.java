package theSmallApp;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 * 시간표 만들고 조회 하기
 * 
 * - 기능
 * 요일, 수업 시간 추가
 * 특정 요일의 수업, 시간 조회
 * 전체 시간표 출력
 * 
 * - 가정
 * 요일은 월-금
 * 9교시까지
 * 
 * - 프로세스
 * 1. 요일을 입력 받는다
 * 1.0 한글인가
 * 1.1 weekdays 인가
 * 
 */
public class TimeTable {

    Map<String, String> schedule;

    public TimeTable() {
        this.schedule = new Hashtable<>();
    }

    /**
     * 요일과 수업시간 추가
     * 
     * @param day
     * @param time
     * @param className
     */
    public void addClass(String day, String time, String className) {
        String keyByDayTime = day + time;
        schedule.put(keyByDayTime, className);
    }

    /**
     * 특정 요일의 수업, 시간 조회
     * 
     * @param day
     * @param time
     * @return
     */
    public String findClass(String day, String time) {
        String keyByDayTime = day + time;
        String getClass = schedule.get(keyByDayTime);

        return getClass;
    }

    /**
     * 시간표를 출력한다.
     */
    public void printAllClasses() {
        for (Map.Entry<String, String> entry : schedule.entrySet()) {
            String key = entry.getKey();
            String className = entry.getValue();
            System.out.println(key + " : " + className);
        }
    }

    /**
     * 입력된 글자가 한글인지 검증한다.
     * 
     * @param input
     */
    public static void validateKoreanInput(String input) {
        if (!input.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
            throw new IllegalArgumentException("한글만 입력하세요.");
        }
    }

    /**
     * 입력된 요일이 주중인지 검증한다.
     * 
     * @param input
     */
    public static void validateWeekdaysInput(String input) {
        String[] validWeekdays = { "월", "화", "수", "목", "금" };

        boolean isValid = false;
        for (String weekday : validWeekdays) {
            if (input.equals(weekday)) {
                isValid = true;
                break;

            }
        }
        if (!isValid) {
            throw new IllegalArgumentException("(월 / 화 / 수 / 목 / 금) 중에 입력하세요.");
        }
    }

    /**
     * 1교시부터 9교시까지만 입력 가능하도록 제한한다.
     * 
     * @param input
     */
    public static void validateNumberInput(String input) {
        if (!input.matches("[1-9]")) {
            throw new IllegalArgumentException("1부터 9까지 유효합니다.");
        }
    }

    /**
     * 과목 명 길이를 체크한다.
     * 
     * @param input
     */
    public static void checkTheNumberOfLetters(String input) {
        int count = input.length();
        if (count > 15) {
            throw new IllegalArgumentException("과목명은 15자 미만입니다.");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String day;
        String time;
        String className;

        System.out.println(" ======= 시간표 입력을 시작합니다. =======");
        TimeTable timeTable = new TimeTable();
        while (true) {

            System.out.println("요일을 입력하세요.");
            day = scanner.nextLine();
            validateKoreanInput(day);
            validateWeekdaysInput(day);

            System.out.println("시간을 입력하세요");
            time = scanner.nextLine();
            validateNumberInput(time);

            System.out.println("과목을 입력하세요");
            className = scanner.nextLine();
            validateKoreanInput(className);
            checkTheNumberOfLetters(className);

            timeTable.addClass(day, time, className);

            System.out.println("더 입력하시겠습니까? (Y/N)");
            String moreInput = scanner.nextLine();
            if (!moreInput.equalsIgnoreCase("Y")) {
                break;
            }
        }
        scanner.close();

        System.out.println("======= 생성된 시간표를 출력합니다. =======");
        timeTable.printAllClasses();

    }
}
