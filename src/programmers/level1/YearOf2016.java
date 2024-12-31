package programmers.level1;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class YearOf2016 {
    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }

    /**
     * SUN, MON, TUE, WED, THU, FRI, SAT
     * 2016.01.01은 금요일
     * 2016.a.b는 무슨 요일?
     * 2016은 윤년(2월 29일)
     */
    public static String solution1(int a, int b) {
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] dayOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 해당 월 전까지의 일 수
        int sum = 0;
        for (int i = 0; i < a - 1; i++) {
            sum += dayOfMonth[i];
        }
        sum += (b - 1); // 1.1제외
        return days[sum % 7];
    }

    public static String solution(int a, int b) {
        Calendar cal = new Calendar.Builder().setCalendarType("iso8601").setDate(2016, a - 1, b).build();
        return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
    }
}
