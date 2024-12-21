package baaaaaaaaarikingDog;

public class bark3 {
    public static void main(String[] args) {
        System.out.println(func3(9));
        System.out.println(func3(12));
        System.out.println(func3(756580036));
    }

    // 제곱수면 1, 아님 0
    public static int func3(int n) {
        for (int i = 0; i <= Math.sqrt(n); i++) {
            if (i * i ==   n) {
                return 1;
            }
        }
        return 0;
    }
}
