package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    /**
     * 가장 긴 접두사 반환
     * str ["flower","flow","flight"]
     * => "fl"
     *
     * 정렬할 생각을 못했음
     */
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return builder.toString();
            }
            builder.append(first.charAt(i));
        }
        return builder.toString();
    }
}
