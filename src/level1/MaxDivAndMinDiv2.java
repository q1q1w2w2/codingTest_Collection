package level1;

import java.util.Arrays;

public class MaxDivAndMinDiv2 {
    public static void main(String[] args) {
        MaxDivAndMinDiv2 clazz = new MaxDivAndMinDiv2();
        int[] s1 = clazz.gcdlcm(14, 12);
        System.out.println("s1 = " + Arrays.toString(s1));
    }

    public int[] gcdlcm(int a, int b) {
        int[] answer = new int[2];

        answer[0] = gcd(a, b);
        answer[1] = (a * b) / answer[0];
        return answer;
    }

    public static int gcd(int n, int m) {
        if (m == 0) return n;
        return gcd(m, n % m);
    }
}
