package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar2 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkewp"));

    }

    /**
     * 반복되는 문자 없는 문자열 중 가장 긴 문자열 길이 반환
     *
     * s = abcabcbb / abc
     *
     */
    public static int lengthOfLongestSubstring(String s) {
        int answer = 0;

        int first = 0;
        int last = 0;

        while (last < s.length()) {
            Set<Character> set = new HashSet<>();
            String str = s.substring(first, last + 1);
            for (char c : str.toCharArray()) {
                set.add(c);
            }
            if (set.size() == str.length()) {
                answer = Math.max(answer, set.size());
                last++;
            } else {
                first++;
            }
        }
        return answer;
    }
}
