package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("IV")); // 4
        System.out.println(romanToInt("VI")); // 6
        System.out.println(romanToInt("III")); // 6
    }

    /**
     * 로마 숫자
     * I:1
     * V:5
     * X:10
     * L:50
     * C:100
     * D:500
     * M:1000
     *
     * ex
     * 2 -> II
     * 6 -> IV
     * 27 -> XXVII
     *
     * 근데 앞에 작은 수가 오면 빼기 연산
     * VI -> 6 / IV -> 4
     */
    public static int romanToInt1(String s) {
        int total = 0;
        Integer before = null;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (Character c : s.toCharArray()) {
            Integer num = map.get(c);
            if (before == null || num <= before) {
                total += num;
            } else {
                total -= before;
                total -= before;
                total += num;
            }
            before = num;
        }
        return total;
    }

    public static int romanToInt(String s) {
        int total = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                total -= map.get(s.charAt(i));
            } else {
                total += map.get(s.charAt(i));
            }
        }

        return total;
    }
}
