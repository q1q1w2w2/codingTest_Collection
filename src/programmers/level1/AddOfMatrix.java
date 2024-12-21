package programmers.level1;

import java.util.Arrays;

public class AddOfMatrix {
    public static void main(String[] args) {
        AddOfMatrix clazz = new AddOfMatrix();
        int[][] solution1 = clazz.solution(new int[][]{{1, 2}, {2, 3}}, new int[][]{{3, 4}, {5, 6}});
        // [[4,6], [7,9]]
        System.out.println("solution1 = " + Arrays.deepToString(solution1));
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = arr1;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                answer[i][j] += arr2[i][j];
            }
        }
        return answer;
    }
}
