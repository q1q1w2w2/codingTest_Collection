package level1;

import java.util.Arrays;

public class TurnNaturalNumToArray {
    public static void main(String[] args) {
        TurnNaturalNumToArray turnNaturalNumToArray = new TurnNaturalNumToArray();
        int[] solution = turnNaturalNumToArray.solution(12345);
        System.out.println("solution = " + turnNaturalNumToArray.toString(solution));
    }

    public int[] solution1(long n) {
        String s = String.valueOf(n);
        int length = s.length();
        int[] list = new int[length];

        for (int i = 0; i < length; i++) {
            list[i] = s.charAt(length - 1 - i) - '0';
        }
        return list;
    }


    public int[] solution2(long n) {
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }

    public int[] solution3(long n) {
        String s = Long.toString(n);
        int[] answer = new int[s.length()];
        int cnt = 0;
        while (n > 0) {
            answer[cnt] = (int) (n % 10);
            n /= 10;
            cnt++;
        }
        return answer;
    }

    public int[] solution(long n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        String[] split = sb.toString().split("");

        int[] answer = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            answer[i] = Integer.parseInt(split[i]);
        }
        return answer;
    }

    public String toString(int[] arr) {
        return Arrays.toString(arr);
    }
}
