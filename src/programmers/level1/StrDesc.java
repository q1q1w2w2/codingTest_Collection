package programmers.level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StrDesc {
    public static void main(String[] args) {
        StrDesc clazz = new StrDesc();
        String solution1 = clazz.solution4("Zbcdefg");
        System.out.println("solution1 = " + solution1);
    }

    /**
     * s에 나타나는 문자를 큰 것부터 작은 순으로
     * Zbcdefg -> gfedcbZ
     * 아스키 A65 a97
     */
    public String solution(String s) {

        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);

        char[] arr = new char[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            arr[i] = charArray[charArray.length - i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String solution2(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new StringBuilder(new String(charArray)).reverse().toString();
    }

    public String solution3(String s) {
        String[] split = s.split("");
        return Stream.of(split)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());
    }

    public String solution4(String s) {
        char[] charArray = s.toCharArray();
        String lower = "";
        String upper = "";

        for (int i = 0; i < charArray.length; i++) {
            char chnum = charArray[i];
            if (chnum >= 65 && chnum <= 90) {
                upper += charArray[i];
            } else {
                lower += charArray[i];
            }
        }

        char[] chUpper = upper.toCharArray();
        char[] chLower = lower.toCharArray();
        lower = "";
        upper = "";

        Arrays.sort(chUpper);
        Arrays.sort(chLower);

        for (int i = chUpper.length - 1; i >= 0; i--) {
            upper += chUpper[i];
        }
        for (int i = chLower.length - 1; i >= 0; i--) {
            lower += chLower[i];
        }

        return lower + upper;
    }
}
