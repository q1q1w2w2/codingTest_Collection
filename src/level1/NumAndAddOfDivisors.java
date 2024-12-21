package level1;

import java.util.HashSet;
import java.util.Set;

public class NumAndAddOfDivisors {
    public static void main(String[] args) {
        NumAndAddOfDivisors clazz = new NumAndAddOfDivisors();
        int solution1 = clazz.solution(13, 17); // 43
        System.out.println("solution1 = " + solution1);
        int solution2 = clazz.solution(24, 27); // 52
        System.out.println("solution2 = " + solution2);
    }

    /**
     * left부터 right까지의 수 중 약수 개수가 짝수면 더하고, 약수 개수가 홀수면 뺀 수를 반환
     * 13, 17 -> 13, 14, 15, 16, 17
     * 13: 1, 13 +
     * 14: 1, 2, 7, 14 +
     * 15: 1, 3, 5, 15 +
     * 16: 1, 2, 4, 8, 16 -
     * 17: 1, 17 +
     ** 13 + 14 + 15 - 16 + 17 = 43
     *
     * 16 -> 제곱근 4 -> 16%1 16%2 16%3 16%4 -> 1,2,4 -> 16,8,4
     *
     */
    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            Set<Integer> set = new HashSet<>();

            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    set.add(j);
                    set.add(i / j);
                }
            }

            answer += set.size() % 2 == 0 ? i : -i;
        }
        return answer;
    }

    public int solution1(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int cnt = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    cnt++;
                }
            }
            answer += cnt % 2 == 0 ? i : -i;
        }
        return answer;
    }

    public int solution2(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            // 제곱수인 경우 약수 개수가 홀수
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            } else {
                answer += i;
            }
        }
        return answer;
    }
}
