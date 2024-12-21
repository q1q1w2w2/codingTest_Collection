package level1;

import java.util.ArrayList;
import java.util.Arrays;

public class NumSpaceByX {
    public static void main(String[] args) {
        NumSpaceByX numSpaceByX = new NumSpaceByX();
        long[] solution1 = numSpaceByX.solution(2, 5);
        long[] solution2 = numSpaceByX.solution(4, 3);
        long[] solution3 = numSpaceByX.solution(-4, 2);

        System.out.println(numSpaceByX.toString(solution1));
        System.out.println(numSpaceByX.toString(solution2));
        System.out.println(numSpaceByX.toString(solution3));
    }

    // x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트 반환
    public long[] solution(int x, int n) {
        long[] list = new long[n];
        list[0] = x;
        for (int i = 1; i < n; i++) {
            list[i] = list[i - 1] + x;
        }
        return list;
    }

    public String toString(long[] arr) {
        return Arrays.toString(arr);
    }
}
