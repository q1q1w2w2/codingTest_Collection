package baekjoon;

import java.util.Scanner;

public class Make1 {
    static Integer[] dp;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        dp = new Integer[n + 1];
        dp[0] = dp[1] = 0;

        System.out.println(recur(n));
    }

    static int recur(int n){
        if (dp[n] == null) {
            if (n % 6 == 0) {
                dp[n] = Math.min(recur(n / 3), Math.min(recur(n / 2), recur(n - 1))) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(recur(n / 3), recur(n - 1)) + 1;
            } else if (n % 2 == 0) { // 1. 10이면 여기서 걸림 -> 2로 나눌지, 1을 뺄지
                dp[n] = Math.min(recur(n / 2), recur(n - 1)) + 1;
            } else {
                dp[n] = recur(n - 1) + 1;
            }
        }
        return dp[n];
    }
    /**
     * dp[0] = 0
     * dp[1] = 0
     * dp[2] = dp[1] + 1 = 1
     * dp[3] = dp[1] + 1 = 1
     * dp[4] = Min(dp[2],dp[3]) + 1 = 2
     * dp[5] = dp[4] + 1 = 2 + 1 = 3
     * dp[6] = Min(dp[3],dp[2],dp[5]) + 1 = 2
     * dp[7] = dp[6] + 1 = 3
     * dp[8] = Min(dp[7],dp[4]) + 1 = 3
     * dp[9] = Min(dp[3],dp[8]) + 1 = 2
     * dp[10] = Min(dp[5], dp[9]) + 1 = 3
     */

    // 최소 연산 횟수를 구해야 함
    /**
     * 3과 2로 나누어지는 경우 -> 3으로 나눔 / 2로 나눔 / 1을 뺌
     * 3으로 나누어지는 경우 -> 3으로 나눔 / 1을 뺌
     * 2로 나누어지는 경우 -> 2로 나눔 / 1을 뺌
     * 3과 2로 나누어지지 않는 경우 -> 1을 뺌
     */
    // 10 -> 9 -> 3 -> 1
}
