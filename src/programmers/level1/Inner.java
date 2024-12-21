package programmers.level1;

import java.util.stream.IntStream;

public class Inner {
    public static void main(String[] args) {
        Inner inner = new Inner();
        int solution1 = inner.solution(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2});
        System.out.println("solution1 = " + solution1);
        int solution2 = inner.solution(new int[]{-1, 0, 1}, new int[]{1, 0, -1});
        System.out.println("solution2 = " + solution2);
    }

    /**
     * 내적: [1, 2, 3, 4] [5, 6, 7, 8] 일 때
     * (1 * 5) + (2 * 6) + ... 의 값 반환
     */
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }

    public int solution2(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(i -> a[i] * b[i]).sum();
    }
}
