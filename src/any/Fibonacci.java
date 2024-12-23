package any;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
        System.out.println(fibonacciLoop(3));
    }

    static int fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int fibonacciLoop(int n) {
        int answer = 1;
        int before = 1;
        int temp;
        for (int i = 2; i < n; i++) {
            temp = answer;
            answer += before;
            before = temp;
        }
        return answer;
    }
}
