package programmers.level1;

import java.util.*;

public class FailureRate {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
//        System.out.println(Arrays.toString(solution(5, new int[]{4, 4, 4, 4, 4})));
    }

    /**
     * 실패율: 스테이지에 도달했으나 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수
     * 전체 스테이지 수: N
     * 게임을 이용하는 사용자가 멈춰있는 스테이지 번호의 모음: stages
     * 실패율이 높은 스테이지부터 내림차순으로 스테이지 번호가 담긴 배열을 반환
     * <p>
     * N = 5 / [2,1,2,6,2,4,3,3] -> 현재 도전 중인 스테이지 번호(클리어는 -1 해야함)
     * 스테이지 5까지 있음
     * 1 2 3 4 5에 도달한 유저 수: 8 7 4 2 1
     * 1 2 3 4 5를 클리어한 유저(스테이지+1 개수): 7 4 2 1 1
     * 각 실패율: 7/8 4/7 2/4 1/2 1
     * <p>
     * + 스테이지에 도달한 사람 없으면 0임
     */
    public static int[] solution1(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            int count = 0;
            int clear = 0;
            for (int stage : stages) {
                if (i <= stage) { // 도달한 사람
                    count++;
                }
                if (i < stage) { // 클리어한 사람
                    clear++;
                }
            }
            // 실패율: 도달했지만 클리어 못함 / 도달한 사람
            // 근데 도달한 사람 없으면 0으로 침
            if (count == 0) {
                map.put(i, 0.0);
            } else {
                map.put(i, (double) (count - clear) / count);
            }
        } // 스테이지별 실패율 구해짐
        System.out.println("map = " + map);

        List<Map.Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> {
            int compare = b.getValue().compareTo(a.getValue());
            if (compare == 0) { // 실패율 같으면
                return a.getKey().compareTo(b.getKey());
            }
            return compare;
        });

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] fail = new double[N];
        int remain = stages.length;

        System.out.println("stages = " + Arrays.toString(stages));
        System.out.println("=====================");

        // 각 스테이지에 도달한 사람 수
        for (int i = 0; i < stages.length; i++) {
            if (stages[i] != N + 1) {
                answer[stages[i] - 1] += 1; // 스테이지에 도달한 사람 수 계산
            }
        }
        System.out.println("answer = " + Arrays.toString(answer));
        System.out.println("tempArr = " + Arrays.toString(fail));
        System.out.println("=====================");

        // 실패율 계산
        for (int i = 0; i < N; i++) {
            fail[i] = (double) answer[i] / remain; // 실패율
            answer[i] = i + 1; // 스테이지 번호 저장
            remain -= answer[i]; // 남은 사람 수 계산
        }
        System.out.println("answer = " + Arrays.toString(answer));
        System.out.println("tempArr = " + Arrays.toString(fail));
        System.out.println("=====================");

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N - i; j++) {
                if (fail[j] > fail[j - 1]) {
                    double tempD = fail[j - 1];
                    fail[j - 1] = fail[j];
                    fail[j] = tempD;

                    int tempI = answer[j - 1];
                    answer[j - 1] = answer[j];
                    answer[j] = tempI;
                }
            }
        }
        return answer;
    }
}