package level2;

import java.util.Arrays;
import java.util.stream.Stream;

public class MaxAndMin {
    public static void main(String[] args) {
        MaxAndMin maxAndMin = new MaxAndMin();
        String solution1 = maxAndMin.solution("1 2 3 4");
        String solution2 = maxAndMin.solution("-1 -2 -3 -4");
        String solution3 = maxAndMin.solution("-1 -1");
        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }

    /**
     * str에 나타나는 숫자 중 "최소값 최대값"
     * "1 2 3 4" -> "1 4"
     */
    public String solution(String s) {
        String[] split = s.split(" ");
        int[] array = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        int min = Arrays.stream(array).min().getAsInt();
        int max = Arrays.stream(array).max().getAsInt();

        return min + " " + max;
    }

    public String solution2(String s) {
        String[] split = s.split(" ");
        int max = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[0]);

        for (String str : split) {
            int i = Integer.parseInt(str);
            if (i > max) max = i;
            if (i < min) min = i;
//            max = Math.max(max, i);
//            min = Math.min(min, i);
        }
        return max + " " + min;
    }
}
