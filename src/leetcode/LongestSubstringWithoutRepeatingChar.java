package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
//        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(lengthOfLongestSubstring("pwwkewp")); // 4
    }

    /**
     * 반복 없이 가장 긴 부분 문자열 구하는거
     * pwwkew -> wke
     *
     * p -> 저장 [temp = 1]
     * pw -> [temp = pw] -> [result = 2]
     * pww -> 중복 발생 -> w부터 다시 시작
     * w -> result.length와 비교해서 짧으므로 [temp = w]
     * wk -> [temp = wk]
     * wke -> [temp = wke] [result = 3]
     * wkew -> 중복 -> 이 경우는 k부터 재시작해야하는데
     *
     * 두 개의 포인터(시작 포인터, 끝 포인터 사용)
     */

    /**
     * 반복 없이 가장 긴 부분 문자열 구하기
     * start포인터와 end포인터를 활용
     * 중복 발생 시, start++
     * 중복 없을 시, end++
     * end == s.length-1이면 break
     */
    public static int lengthOfLongestSubstring1(String s) {
        int result = 0;

        int start = 0;
        int end = 0;

        while (end < s.length()) {
            Set<Character> set = new HashSet<>();
            System.out.println("====================");
            String substring = s.substring(start, end + 1);
            System.out.println("start = " + start + ", end = " + end + ", substring = " + substring + " ,result = " + result);
            for (char c : substring.toCharArray()) {
                set.add(c);
            }
            if (set.size() == substring.length()) {
                result = Math.max(result, substring.length());
                end++;
            } else {
                start++;
            }
            System.out.println("start = " + start + ", end = " + end + ", substring = " + substring + " ,result = " + result);
        }
        return result;
    } // n^2

    public static int lengthOfLongestSubstring2(String s) {
        int result = 0;

        Set<Character> chars = new HashSet<>();
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            while (chars.contains(s.charAt(end))) {
                chars.remove(s.charAt(end));
                start++;
            }
            chars.add(s.charAt(end));
            result = Math.max(result, end - start + 1);
        }
        return result;
    } // n

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
            System.out.println("left = " + left + ", right = " + right + ", set = " + charSet);
        }

        return maxLength;
    }
}
