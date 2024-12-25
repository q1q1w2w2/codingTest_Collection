package test;

import java.util.*;

public class ConvertBinary {
    public static void main(String[] args) {
        int num = 13; // 1101
        int iterations = 1000000; // 테스트 횟수

        long start1 = System.currentTimeMillis();

        for (int i = 0; i < iterations; i++) {
            int n = num;
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            while (n != 0) {
                stack.add(n % 2);
                n /= 2;
            }
//        System.out.println("stack = " + stack);
            StringBuilder builder = new StringBuilder();
            while (!stack.isEmpty()) {
                builder.append(stack.removeLast());
//            System.out.println("stack = " + stack);
            }
            String result = builder.toString();
//        System.out.println("result = " + result);
        }

        long end1 = System.currentTimeMillis();
        System.out.println("time1 = " + (end1 - start1) + "ms");

        // =================================================

        // toBinaryString 사용이 훨씬 빠름
        long start2 = System.currentTimeMillis();

        for (int i = 0; i < iterations; i++) {
            int n = num;
//            String binaryString = Integer.toBinaryString(n);
            String binaryString = Integer.toString(n, 2);
//            System.out.println("binaryString = " + binaryString);
        }

        long end2 = System.currentTimeMillis();
        System.out.println("time2 = " + (end2 - start2) + "ms");
    }
}
