package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        print(list);
    }

    public static void print(List<? extends Object> arr) {
        for (Object e : arr) {
            System.out.println("e = " + e);
        }
    }
}
