package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("qwer", "aw", "qwerqwer");

        List<Integer> list1 = list.stream()
                .map(String::length)
                .toList();

        System.out.println("list1 = " + list1);

        List<String> collect = list.stream()
                .filter(s -> s.startsWith("q"))
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        int avg = (int) nums.stream()
                .mapToInt(i -> i)
                .average()
                .orElse(0);
        System.out.println("avg = " + avg);

        List<Integer> list2 = nums.stream()
                .sorted((a, b) -> b.compareTo(a))
                .toList();
        System.out.println("list2 = " + list2);
    }
}
