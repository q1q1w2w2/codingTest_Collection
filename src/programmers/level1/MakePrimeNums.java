package programmers.level1;

public class MakePrimeNums {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution(new int[]{1, 2, 7, 6, 4}));
    }

    /**
     * nums의 수 중 3개의 수를 더했을 때 소수가 되는 경우의 수
     * 3 <= nums.length <= 50
     *
     * [1,2,3,4]
     * 124 7
     * [1,2,3,4,5]
     * 124 7, 245 11
     */
    public static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isPrime(nums[i] + nums[j] + nums[k])) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static boolean isPrime(int x) {
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
