package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum clazz = new TwoSum();
        int[] answer= clazz.twoSum1(new int[]{5, 1, 7, 8, 9}, 9);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if (map.containsKey(find) && map.get(find) != i) {
                return new int[]{i, map.get(find)};
            }
        }

        return new int[]{-1, -1}; // 시간복잡도 n
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result; // 시간복잡도 n제곱
    }
}
