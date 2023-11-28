package theSmallApp;

import java.time.DayOfWeek;
import java.util.Hashtable;
import java.util.Map;

/**
 * 시간표 만들고 조회 하기
 * 
 * - 기능
 * 요일, 수업 시간 추가
 * 특정 요일의 수업, 시간 조회
 * 전체 시간표 출력
 * 
 * - 프로세스
 * 1. 요일을 입력 받는다
 * 1.0 한글인가
 * 1.1 weekdays 인가
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
     * 시간표 출력
     */
    public void printAllClass() {
        for (Map.Entry<String, String> entry : schedule.entrySet()) {
            String key = entry.getKey();
            String className = entry.getValue();
            System.out.println(key + " : " + className);
        }
    }

    /**
     * 한글인지 확인
     * 
     * @param day
     * @return
     */
    public static boolean isKorean(String day) {
        return day.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*");
    }

    /**
     * DayOfWeek 열거형의 한글 요일명을 반환
     * 
     * @param dayOfWeek
     * @return
     */
    public static String getKoreanDayOfWeek(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY:
                return "월요일";
            case TUESDAY:
                return "화요일";
            case WEDNESDAY:
                return "수요일";
            case THURSDAY:
                return "목요일";
            case FRIDAY:
                return "금요일";
            default:
                return "";
        }
    }

    public static void main(String[] args) {

    }
}
