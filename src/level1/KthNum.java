package level1;

import java.util.Arrays;

public class KthNum {
    public static void main(String[] args) {
        KthNum clazz = new KthNum();
        int[] solution1 = clazz.solution(
                new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}
        );
        System.out.println("solution1 = " + Arrays.toString(solution1));
    }

    /**
     * array의 i번째부터 j번째까지 자르고 정렬했을 때 ,k번째 수 구하기
     * {1, 5, 2, 6, 3, 7, 4} / 2,5,3
     * {5, 2, 6, 3} 정렬 {2, 3, 5, 6} 의 3번째 5
     * 인덱스로 바꾸면 -1, {2, 5, 3} -> {1, 4, 3}(i=0일 경우 안나온다고 가정)
     */
    public int[] solution1(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] temp = new int[commands[i][1] - commands[i][0] + 1];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = array[commands[i][0] + j - 1];
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }
        return answer;
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }
        return answer;
    }
}
