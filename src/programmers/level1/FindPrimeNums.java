package programmers.level1;

import java.util.Arrays;

public class FindPrimeNums {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    /**
     * 1~n 사이의 소수 개수를 반환
     *
     * 소수 => 1과 자기 자신으로만 나누어짐
     *
     */
    public static int solution1(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            int cnt = 0;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    cnt++;
                }
            }
            if (cnt == 0) {
                answer++;
            }
        }
        return answer;
    } // 효율성 테스트 실패

    // 에라토스테네스의 체
    public static int solution2(int n) {
        int answer = 0;

        boolean[] numbers = new boolean[n + 1]; // false 배열 초기화

        for (int i = 2; i <= n; i++) {
            // 2부터 boolean값이 false면 처음 방문하는 수 => 소수
            // 해당 인덱스를 true로 바꾸고, 소수 개수 +
            //
            if(!numbers[i]) {
                answer++;
                for (int j = i * 2; j <= n; j += i) {
                    numbers[j] = true;
                }
            }
        }
        return answer;
    }

    public static int solution(int n) {
        int answer = 0;
        boolean[] numbers = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            if (!numbers[i]) { // 이러면 소수임(2부터 시작이라)
                answer++; // 소수 개수 올리고
                for (int j = i * 2; j <= n; j += i) { // 소수의 배수 전부 지우기(소수의 배수는 소수가 될 수 없음)
                    numbers[j] = true; // 소수 아닌애들 true
                }
            }
        }
        return answer;
    }

}
