package programmers.level1;

import java.util.*;

public class NumericStrAndEng {
    public static void main(String[] args) {
        NumericStrAndEng clazz = new NumericStrAndEng();
        int solution1 = clazz.solution("one4seveneight"); // 1478
        int solution2 = clazz.solution("23four5six7"); // 234567
        int solution3 = clazz.solution("2three45sixseven"); // 234567
        int solution4 = clazz.solution("123"); // 123
        int solution5 = clazz.solution("999");

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
        System.out.println("solution4 = " + solution4);
        System.out.println("solution5 = " + solution5);
    }

    /**
     * 문자열에서 숫자가 아닌 영어인 경우 숫자로 변환해야 함
     * charAt해서 숫자면 그대로 추가하고
     * 3~5자
     */
    public int solution1(String s) {
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        StringBuilder builder = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                builder.append(s.charAt(i));
            } else {
                temp.append(s.charAt(i));
            }

            if (temp.length() >= 3) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j].equals(temp.toString())) {
                        builder.append(j);
                        temp.delete(0, temp.length());
                    }
                }
            }
        }
        return Integer.parseInt(builder.toString());
    }

    public int solution(String s) {
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < arr.length; i++) {
            s = s.replaceAll(arr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }

}
