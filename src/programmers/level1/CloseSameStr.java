package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class CloseSameStr {
    public static void main(String[] args) {
        CloseSameStr clazz = new CloseSameStr();
        int[] solution1 = clazz.solution("banana");
        int[] solution2 = clazz.solution("foobar");

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));

    }

    /**
     * 문자열 s의 각 위치마다 자신보다 앞에 있으면서, 가장 가까운 곳에 있는 글자의 거리
     * "banana"
     * b 앞에 같은거 없음 -1
     * a 처음 나옴 -1
     * n 처음 나옴 -1
     * a 두 칸 앞에 같은거 2
     * n 두 칸 앞에 같은거 2
     * a 두 칸 앞, 네 칸 앞 2
     * [-1, -1, -1, 2, 2, 2]
     */
    // 시간복잡도 n제곱
    public int[] solution1(String s) {
        int[] result = new int[s.length()];
        Arrays.fill(result, -1);
        char[] charArray = s.toCharArray();

        for (int i = 1; i < charArray.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (charArray[i] == charArray[j]) {
                    result[i] = i - j;
                    break;
                }
            }
        }
        return result;
    }

    public int[] solution2(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            answer[i] = i - map.getOrDefault(ch, i + 1);
            map.put(ch, i);
        }
        return answer;
    }

    public int[] solution(String s) {
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            String substr = s.substring(0, i);
            if (substr.indexOf(s.charAt(i)) == -1) {
                result[i] = -1;
            } else {
                result[i] = i - substr.lastIndexOf(s.charAt(i));
            }
        }
        return result;
    }

}
