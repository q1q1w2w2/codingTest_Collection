package test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ParallelStream {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(6);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        long start = System.currentTimeMillis();

        numbers.forEach(number -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        long duration = System.currentTimeMillis() - start;
        System.out.println("normal duration = " + duration + "ms");

        System.out.println("===============================");

        start = System.currentTimeMillis();

        numbers.parallelStream().forEach(number -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        duration = System.currentTimeMillis() - start;
        System.out.println("parallel duration = " + duration + "ms");

    }
}
