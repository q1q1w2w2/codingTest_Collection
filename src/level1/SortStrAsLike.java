package level1;

import java.util.*;

public class SortStrAsLike {
    public static void main(String[] args) {
        SortStrAsLike clazz = new SortStrAsLike();
        String[] solution1 = clazz.solution(new String[]{"car", "bed", "sun"}, 1); // a, e, u
        String[] solution2 = clazz.solution(new String[]{"abce", "abcd", "cdx"}, 2); // c, c, d

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
    }

    /**
     * ["sun","bed","car"], 인덱스 n 순서대로 문자열 정렬(겹치면 사전순)
     * n = 1이라면, u, e, a로 정렬 -> a, e, u
     */
    public String[] solution(String[] strings, int n) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                char target = strings[i].charAt(n);
                char compare = strings[j].charAt(n);
                if (target > compare) {
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                } else if (target == compare) {
                    if (strings[i].compareTo(strings[j]) > 0) {
                        String temp = strings[i];
                        strings[i] = strings[j];
                        strings[j] = temp;
                    }
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("실행시간: " + (end - start) + "ms");
        return strings;
    }

    public String[] solution2(String[] strings, int n) {
        long start = System.currentTimeMillis();

        String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arr.add("" + strings[i].charAt(n) + strings[i]); // 문자열 앞에 비교할 문자 붙여서 그대로 비교 후 제거
        }
        Collections.sort(arr);
        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }

        long end = System.currentTimeMillis();
        System.out.println("실행시간: " + (end - start) + "ms");

        return answer;
    }

    public String[] solution3(String[] strings, int n) {
        long start = System.currentTimeMillis();

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.charAt(n) > s2.charAt(n)) return 1;
                else if (s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
                else if (s1.charAt(n) < s2.charAt(n)) return -1;
                else return 0;
            }
        });

        long end = System.currentTimeMillis();
        System.out.println("실행시간: " + (end - start) + "ms");
        return strings;
    }

}
