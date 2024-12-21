package programmers.level1;

import java.util.Arrays;

public class Budget {
    public static void main(String[] args) {
        Budget budget = new Budget();
        int solution1 = budget.solution(new int[]{1, 3, 2, 5, 4}, 9);
        int solution2 = budget.solution(new int[]{2, 2, 3, 3}, 10);

        System.out.println("solution1 = " + solution1); // 3
        System.out.println("solution2 = " + solution2); // 4
    }

    /**
     * @param d
     * 부서별 신청한 예산 [1,3,2,5,4] -> 5개의 부서가 각각 신청한 예산
     * @param budget
     * 전체 예산
     *
     * 최대 몇개의 부서에 예산을 지원할 수 있는지
     *
     * 작은 것부터 하나씩 처리하면
     */
    public int solution(int[] d, int budget) {
        int cnt = 0;
        Arrays.sort(d);
        for (int i : d) {
            budget -= i;
            if (budget < 0) {
                break;
            }
            cnt++;
        }
        return cnt;
    }
}
