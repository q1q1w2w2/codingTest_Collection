package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockTest {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5}))); // [1]
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2}))); // [1,2,3]
    }

    /**
     * 문제 찍는 방식 3가지 중 가장 많은 문제를 맞추는 경우
     * 1. 1 2 3 4 5 / 1 2 3 4 5
     * 2. 2 1 2 3 2 4 2 5 / 2 1 2 3 2 4 2 5
     * 3. 3 3 1 1 2 2 4 4 5 5 / 3 3 1 1 2 2 4 4 5 5
     *
     * 가장 높은 점수를 받는 사람이 여러 명이면 오름차순
     */
    public static int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (first[i % first.length] == answers[i]) {
                scores[0]++;
            }
            if (second[i % second.length] == answers[i]) {
                scores[1]++;
            }
            if (third[i % third.length] == answers[i]) {
                scores[2]++;
            }
        }

        List<Integer> list = new ArrayList<>();
        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) {
                list.add(i + 1);
            }
        }

        // 배열로 변경
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
