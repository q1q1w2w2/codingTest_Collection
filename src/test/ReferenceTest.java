package test;

import java.util.Arrays;

public class ReferenceTest {
    public static void main(String[] args) {
        int[] arr = {10};
        ReferenceTest clazz = new ReferenceTest();
        clazz.add(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    void add(int[] arrArg) {
        arrArg[0]++;
    }
}
