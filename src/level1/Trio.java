package level1;

public class Trio {
    public static void main(String[] args) {
        Trio trio = new Trio();
        int solution1 = trio.solution(new int[]{-2, 3, 0, 2, -5});
        int solution2 = trio.solution(new int[]{-3, -2, -1, 0, 1, 2, 3});
        int solution3 = trio.solution(new int[]{-1, 1, -1, 1});

        System.out.println("solution1 = " + solution1); // 2
        System.out.println("solution2 = " + solution2); // 5
        System.out.println("solution3 = " + solution3); // 0
    }

    /**
     * 3명의 정수 번호를 더해 0이되면 3명의 학생을 삼총사라고 함
     * 5명 -> -2 3 0 2 -5에서
     * -2 0 2를 더하면 0이므로 세명을 삼총사 or
     * 3 2 -5를 더해도 0이므로 두 가지 방법
     * 삼총사를 만들 수 있는 방법의 수
     *
     * 1. 그냥 3개씩 엮어서 모든 경우의 수 찾기
     */
    public int solution(int[] number) {
        int cnt = 0;
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length-1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
