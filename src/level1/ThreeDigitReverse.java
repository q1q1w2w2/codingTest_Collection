package level1;

public class ThreeDigitReverse {
    public static void main(String[] args) {
        ThreeDigitReverse clazz = new ThreeDigitReverse();
        int solution1 = clazz.solution(45);
        int solution2 = clazz.solution(125);
        System.out.println("solution1 = " + solution1); // 7
        System.out.println("solution2 = " + solution2); // 229

        int solution3 = clazz.solution(3);
        System.out.println("solution3 = " + solution3);
    }

    /**
     * n을 3진법으로 바꿔 뒤집고 다시 10진법으로 표현
     *
     * 45 -> ... 81 27 9 3 1 (3진법) 으로 변경
     * 45/3 -> 15...0
     * 15/3 -> 5...0
     * 5/3 -> 1...2
     * 1
     * 1200
     * 마지막 몫이 1 or 2가 될 때까지 나누고
     * 그 몫부터 나머지를 순서대로
     * 3진수 -> 10진수
     * 1200 -> 1 * 3^3 + 2 * 3^2 = 27 + 18 = 45
     */
    public int solution1(int n) {
        StringBuilder builder = new StringBuilder();
        while (n >= 3) {
            builder.append(n % 3);
            n /= 3;
        }
        builder.append(n);

        String threeDigit = builder.toString();
        char[] charArray = threeDigit.toCharArray();

        int answer = 0;
        for (int i = 0; i < charArray.length; i++) {
            answer += (charArray[i] - '0') * (int) Math.pow(3, charArray.length - i - 1);
        }
        return answer;
    }

    public int solution(int n) {
        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            builder.append(n % 3);
            n /= 3;
        }
        String s = builder.toString();
        return Integer.parseInt(s, 3); // 3진수 -> 10진수 자동변환
    }

    public int solution2(int n) {
        StringBuilder b = new StringBuilder();
        String a = Integer.toString(n, 3);

        for (int i = a.length(); i >= 0; i--) {
            b.append(Integer.toString(n, 3).charAt(i));
        }
        return Integer.parseInt(b.toString(), 3);
    }
}
