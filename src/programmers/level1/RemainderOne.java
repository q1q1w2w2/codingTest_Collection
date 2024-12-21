package programmers.level1;

public class RemainderOne {
    public static void main(String[] args) {
        RemainderOne remainderOne = new RemainderOne();
        int solution1 = remainderOne.solution(10);
        int solution2 = remainderOne.solution(12);
        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }

    // n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
