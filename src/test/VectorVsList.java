package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class VectorVsList {
    public static void main(String[] args) {
        final int NUM_ELEMENTS = 900_000;

        List<Integer> linkedList = new LinkedList<>();
        long startArr = System.currentTimeMillis();

        for (int i = 0; i < NUM_ELEMENTS; i++) {
            linkedList.add(i);
        }

        long endArr = System.currentTimeMillis();
        System.out.println("리스트 삽입 시간: " + (endArr - startArr) + "ms");

        long startListFind = System.currentTimeMillis();
        Integer findArr = linkedList.get(800000);
        long endListFind = System.currentTimeMillis();
        System.out.println("리스트 검색 시간: " + (endListFind - startListFind) + "ms");

        Vector<Integer> vector = new Vector<>();
        long startVector = System.currentTimeMillis();
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            vector.add(i);
        }
        long endVector = System.currentTimeMillis();
        System.out.println("벡터 삽입 시간: " + (endVector - startVector) + "ms");

        long startVectorFind = System.currentTimeMillis();
        Integer findVector = vector.get(800000);
        long endVectorFind = System.currentTimeMillis();
        System.out.println("벡터 검색 시간: " + (endVectorFind - startVectorFind) + "ms");
    }
}
