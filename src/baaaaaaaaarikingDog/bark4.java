package baaaaaaaaarikingDog;

public class bark4 {
    public static void main(String[] args) {
        System.out.println(func4(5)); // 4
        System.out.println(func4(1024)); // 1024
    }

    // n 이하의 수 중 가장 큰 2의 거듭제곱수를 반환
    static int func4(int n) {
        int val = 1;
        while (2 * val <= n) {
            val *= 2;
        }
        return val;


//        int max = 0;
//        for (int i = 0; i * i <= n; i++) {
//            max = i * i;
//        }
//        return max;
    }
}
