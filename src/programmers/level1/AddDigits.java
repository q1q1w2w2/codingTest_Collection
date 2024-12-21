package programmers.level1;

public class AddDigits {
    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        int solution1 = addDigits.solution(123);
        System.out.println("solution1 = " + solution1);

        int solution2 = addDigits.solution2(1234);
        System.out.println("solution2 = " + solution2);
    }

    public int solution(int n) {
        // num = 123이면, 1 + 2 + 3 = 6
//        int answer = 0;
//        answer += num % 10; // 1의 자리
//        num = num / 10; // 12
//        answer += num % 10; // 10의 자리
//        num = num / 10; // 1
//        answer += num % 10; //
//        num = num / 10; // 소수점

        int answer = 0;
        while (n >= 1) {
            answer += n % 10;
            n = n / 10;
        }
        return answer;
    }

    public int solution2(int n) {
        int answer = 0;
        String[] split = String.valueOf(n).split("");
        for (String s : split) {
            Integer i = Integer.valueOf(s);
            answer += i;
        }
        return answer;
    }
}
