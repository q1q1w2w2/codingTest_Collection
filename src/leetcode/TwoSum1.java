package leetcode;

import java.util.Arrays;

public class TwoSum1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 3, 4, 8}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 3, 4, 8}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 3, 4, 8}, 4)));
    }

    /**
     * nums [1, 3, 4, 8]
     * target 7 => 3 + 4
     * answer [1, 2]
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        return answer;
    }
}
