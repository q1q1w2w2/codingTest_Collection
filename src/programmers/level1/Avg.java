package programmers.level1;

import java.util.Arrays;

public class Avg {
    public static void main(String[] args) {
        Avg avg = new Avg();
        double solution1 = avg.solution(new int[]{1, 2, 3, 4});
        double solution2 = avg.solution(new int[]{5, 5});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }

    public double solution(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return (double) sum / arr.length;
    }

    public double solution1(int[] arr) {
        // 속도가 굉장히 느리다고 함
        return Arrays.stream(arr).average().orElse(0);
    }
}
