package baaaaaaaaarikingDog;

import java.util.Scanner;

public class bark1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(func1(n));
    }

    // n 중에서 3의 배수 또는 5의 배수인 수를 모두 합한 값을 반환
    static int func1(int n) {
//        long start = System.currentTimeMillis();
//
//        int result = 0;
//        for (int i = 1; i < n + 1; i++) {
//            if (i % 3 == 0 || i % 5 == 0) {
//                result += i;
//            }
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(start - end + "ms");
//
//        return result;

        // 3의 배수의 합
        int m = n / 3; // 3배수의 최대값
        int sum3 = 3 * m * (m + 1) / 2;

        // 5배수의 합
        int p = n / 5;
        int sum5 = 5 * p * (p + 1) / 2;

        int q = n / 15;
        int sum15 = 15 * q * (q + 1) / 2;

        return sum3 + sum5 - sum15;
    }
}
