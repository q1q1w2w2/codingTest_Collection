package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MemoryScore {
    public static void main(String[] args) {
        int[] solution = solution(
                new String[]{"may", "kein", "kain", "radi"},
                new int[]{5, 10, 1, 3},
                new String[][]{
                        {"may", "kein", "kain", "radi"},
                        {"may", "kein", "brin", "deny"},
                        {"kon", "kain", "may", "coni"}
                }
        );// 19,15,6
        System.out.println("solution = " + Arrays.toString(solution));


    }

    /**
     * name: 이름 목록
     * yearning: 점수
     * 각 photo마다 점수 매길거임
     * 이름에 해당하는 점수만큼
     * [a,b,c][1,2,3] / photo[a,c,d]
     * a = 1, c = 3, d = null -> 1 + 3 = 4
     */
    public static int[] solution1(String[] name, int[] yearning, String[][] photo) {
        int[] answer= new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (int j = 0; j < photo[i].length; j++) {
                for (int k = 0; k < name.length; k++) {
                    if (photo[i][j].equals(name[k])) {
                        score += yearning[k];
                    }
                }
            }
            answer[i] = score;
        }
        return answer;
    } // 시간복잡도 n^3

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer= new int[photo.length];

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        } // [이름:점수] 형태의 HashMap

        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if (map.containsKey(photo[i][j])) {
                    score += map.get(photo[i][j]);
                }
            }
            answer[i] = score;
        }

        return answer;
    } // photo - m / person - p / name - n
    // O(n + m * p)

}
