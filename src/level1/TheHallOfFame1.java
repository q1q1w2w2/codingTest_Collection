package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TheHallOfFame1 {
    public static void main(String[] args) {
        TheHallOfFame1 clazz = new TheHallOfFame1();
        int[] solution1 = clazz.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200});
        int[] solution2 = clazz.solution(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000});
        System.out.println("solution1 = " + Arrays.toString(solution1)); // [10,10,10,20,20,100,100]
        System.out.println("solution2 = " + Arrays.toString(solution2)); // [0,0,0,0,20,40,70,70,150,300]

    }

    /**
     * score => 진행 일차별 점수
     * k => 명예의 전당 목록(k개 만큼만 저장됨)
     * 전당에서 제일 낮은거랑 비교해서 더 크면 교체
     * 매일 명예의 전당 최하위 점수를 저장
     */
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] fame = new int[k]; // 명예의 전당

        for (int i = 0; i < k; i++) {
            fame[i] = score[i];
            System.out.println("init fame = " + Arrays.toString(fame));

            if (i == 0) {
                answer[0] = fame[0];
                continue;
            }
            int min = fame[0];
            for (int j = 0; j < i; j++) {
                if (min > fame[i]) {
                    min = fame[i];
                }
            }
            answer[i] = min;
        }
        for (int i = k; i < score.length; i++) {
            Arrays.sort(fame);
            int min = fame[0];

            if (min < score[i]) { // i 회차 명예의 전당 업데이트
                fame[0] = score[i];
                Arrays.sort(fame);
                min = fame[0];
            }
            answer[i] = min;
        }
        return answer;
    }
}
