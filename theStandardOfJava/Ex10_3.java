package theStandardOfJava;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * 두 날짜 사이에 월급날이 몇 번있는지 계산하여 반환
 */
public class Ex10_3 {
    
    static int paycheckCount(Calendar from, Calendar to) {
        if(from ==null || to == null) {
            return 0;
        }else if(from == to && from.get(Calendar.DAY_OF_MONTH) ==21){
            return 1;
        }

        int fromY = from.get(Calendar.YEAR);
        int fromM = from.get(Calendar.MONTH);
        int fromD = from.get(Calendar.DAY_OF_MONTH);

        int toY = to.get(Calendar.YEAR);
        int toM = to.get(Calendar.MONTH);
        int toD = to.get(Calendar.DAY_OF_MONTH);

        int monDiff = (toY * 12 + toM) - (fromY * 12 + fromM);

        if(monDiff < 0) return 0;

        if(fromD <=21 && toD >=21) {
            monDiff ++;
        } else if(fromD >21 && toD <21) {
            monDiff --;
        }

        return monDiff;
    }

    static void printResult(Calendar from, Calendar to) {
        Date fromDate = from.getTime();
        Date toDate = to.getTime();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(sdf.format(fromDate) + "~" + sdf.format(toDate) + ":");
        System.out.println(paycheckCount(from, to));
    }
    
    public static void main(String[] args) {
        Calendar fromCal = Calendar.getInstance();
        Calendar toCal = Calendar.getInstance();

        fromCal.set(2020, 0, 1);
        toCal.set(2020, 0, 1);
        printResult(fromCal, toCal);

        fromCal.set(2020, 0, 21);
        toCal.set(2020, 0, 21);
        printResult(fromCal, toCal);

        fromCal.set(2020, 0, 1);
        toCal.set(2020, 2, 1);
        printResult(fromCal, toCal);

        fromCal.set(2020, 0, 1);
        toCal.set(2020, 2, 23);
        printResult(fromCal, toCal);

        fromCal.set(2020, 0, 23);
        toCal.set(2020, 2, 21);
        printResult(fromCal, toCal);

        fromCal.set(2021, 0, 22);
        toCal.set(2020, 2, 21);
        printResult(fromCal, toCal);
    }
}


