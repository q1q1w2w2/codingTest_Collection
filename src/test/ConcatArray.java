package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConcatArray {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};

        long start = System.nanoTime();
        int[] arr3 = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
        long end = System.nanoTime();
        System.out.println("arr3 = " + Arrays.toString(arr3));
        System.out.println("time = " + (end - start) + "ns");

        start = System.nanoTime();
        int[] arr4 = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray();
        end = System.nanoTime();
        System.out.println("arr4 = " + Arrays.toString(arr4));
        System.out.println("time = " + (end - start) + "ns");

        start = System.nanoTime();
        int[] arr5 = new int[arr1.length + arr2.length];
        int index = 0;
        for (int i = 0; i < arr1.length; i++) {
            arr5[index++] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            arr5[index++] = arr2[i];
        }
        end = System.nanoTime();
        System.out.println("arr5 = " + Arrays.toString(arr5));
        System.out.println("time = " + (end - start) + "ns");

        start = System.nanoTime();
        int[] arr6 = Arrays.copyOf(arr1, arr1.length + arr2.length);
        System.arraycopy(arr2, 0, arr6, arr1.length, arr2.length);
        end = System.nanoTime();
        System.out.println("arr6 = " + Arrays.toString(arr6));
        System.out.println("time = " + (end - start) + "ns");

        start = System.nanoTime();
        int[] arr7 = Arrays.copyOfRange(arr1, 0, arr1.length + arr2.length);
        System.arraycopy(arr2, 0, arr7, arr1.length, arr2.length);
        end = System.nanoTime();
        System.out.println("arr7 = " + Arrays.toString(arr7));
        System.out.println("time = " + (end - start) + "ns");

    }
}
