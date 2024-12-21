package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class SmallPartStr {
    public static void main(String[] args) {
        SmallPartStr clazz = new SmallPartStr();
        int solution1 = clazz.solution("3141592", "271");
        System.out.println("solution1 = " + solution1); // 2
        int solution2 = clazz.solution("500220839879", "7");
        System.out.println("solution2 = " + solution2); // 8
    }

    /**
     * 1. t에서 p와 길이가 같은 부분문자열 중
     * 2. p보다 작거나 같은 것이 나오는 횟수 반환
     * ex) t = 3141592, p = 271
     * 길이가 3인 부분 문자열: 314, 141, 415, 159, 592
     * 이 중 271보다 작거나 같은 것: 141,159 2개
     */
    public int solution(String t, String p) {

        int cnt = 0;
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            if (Long.parseLong(t.substring(i, i + p.length())) <= Long.parseLong(p)) {
                cnt++;
            }
        }
        return cnt;
    }
}
