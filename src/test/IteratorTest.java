package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class IteratorTest {
    public static void main(String[] args) {
        long dataSize = 1_000_000;
        List<Long> numbers = generateData(dataSize);

        // addAll
        long start = System.currentTimeMillis();
        Set<Long> temp = new HashSet<>(numbers);
        long end = System.currentTimeMillis();
        System.out.println("addAll: " + (end - start) + "ms");

        temp.clear();

        // forEach
        start = System.currentTimeMillis();
        Set<Long> temp1 = new HashSet<>();
        numbers.forEach(temp1::add);
        end = System.currentTimeMillis();
        System.out.println("forEach: " + (end - start) + "ms");

        temp1.clear();

        // stream
        start = System.currentTimeMillis();
        Set<Long> temp2 = new HashSet<>();
        numbers.stream().forEach(temp2::add);
        end = System.currentTimeMillis();
        System.out.println("stream: " + (end - start) + "ms");

        temp2.clear();

        // parallelStream -> 여러 쓰레드를 사용하여 작업을 처리 -> 동시성 문제 발생 가능
        start = System.currentTimeMillis();
        Set<Long> temp3 = ConcurrentHashMap.newKeySet();
        numbers.parallelStream().forEach(temp3::add);
        end = System.currentTimeMillis();
        System.out.println("parallelStream: " + (end - start) + "ms");

        temp3.clear();

        // parallelStream -> collect 사용
        start = System.currentTimeMillis();
        Set<Long> temp4 = numbers.parallelStream().collect(Collectors.toSet());
        end = System.currentTimeMillis();
        System.out.println("parallelStream collect: " + (end - start) + "ms");

        temp4.clear();
    }

    private static List<Long> generateData(long dataSize) {
        List<Long> data = new ArrayList<>();
        for (long i = 0; i < dataSize; i++) {
            data.add(i);
        }
        return data;
    }
}
