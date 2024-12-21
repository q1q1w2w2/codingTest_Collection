package level1;

import java.util.Arrays;

public class MaxDivAndMinDiv {
    public static void main(String[] args) {
        MaxDivAndMinDiv clazz = new MaxDivAndMinDiv();
        int[] solution1 = clazz.solution(3, 12);
        System.out.println("solution1 = " + Arrays.toString(solution1)); // [3,12]

        int[] solution2 = clazz.solution(2, 5);
        System.out.println("solution2 = " + Arrays.toString(solution2)); // [1,10]

        int[] solution3 = clazz.solution(36, 48);
        System.out.println("solution3 = " + Arrays.toString(solution3)); // [12,144]

        int[] solution4 = clazz.solution(648, 232);
        System.out.println("solution4 = " + Arrays.toString(solution4)); // [8,18792]
    }

    /**
     * 두 수를 입력받아 최대공약수와 최소공배수를 반환
     * 최대공약수 - 유클리드 호제법
     * 큰 수를 작은 수로 나누고, 나머지가 0이 아니라면 작은 수 나누기 나머지 반복
     * 최소공배수
     * a와 b의 최소공배수는 a * b를 a와 b의 최대공약수를 나눈 것
     */
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        // n이 큰 수가 되도록
        if (m > n) {
            int temp = n;
            n = m;
            m = temp;
        }

        // 큰 수를 작은 수로 나누고, 나머지가 0이 아니라면 작은 수 나누기 나머지 반복
        int n1 = n;
        int m1 = m;
        while (n1 % m1 != 0) {
            System.out.println("n1, m1 = " + n1 + ", " + m1);
            int temp = n1;
            n1 = m1;
            m1 = temp % m1;
        }
        answer[0] = m1;
        // 최소공배수 = 두 수의 곱 / 최대공약수
        answer[1] = (n * m) / m1;

        return answer;
    }
}
