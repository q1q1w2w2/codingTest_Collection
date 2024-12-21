package programmers.level1;

public class SumOfDivisors {
    public static void main(String[] args) {
        SumOfDivisors sumOfDivisors = new SumOfDivisors();

        int solution1 = sumOfDivisors.solution(12);
        System.out.println("solution1 = " + solution1);

        int solution2 = sumOfDivisors.solution(5);
        System.out.println("solution2 = " + solution2);

        int solution3 = sumOfDivisors.solution(2);
        System.out.println("solution3 = " + solution3);

        int solution4 = sumOfDivisors.solution(16);
        System.out.println("solution4 = " + solution4);
    }

    /**
     * 정수 n의 약수를 모두 더한 값 리턴
     * 12: 1 2 3 4 6 12
     * 16: 1 2 4 8 16
     */
    public int solution(int n) {

        if (n == 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i;
                if (n / i != i) {
                    sum += n / i;
                }
            }
        }
        return sum;

        /*
        int sum = 0;
        for (int i = 1; i < n + 1; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
        */

/*
        if (n == 0) {
            return 0;
        }

        int sum = n;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
        */
    }
}
