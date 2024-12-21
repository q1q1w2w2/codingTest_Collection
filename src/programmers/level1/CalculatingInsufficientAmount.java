package programmers.level1;

public class CalculatingInsufficientAmount {
    public static void main(String[] args) {
        CalculatingInsufficientAmount clazz = new CalculatingInsufficientAmount();
        long solution1 = clazz.solution1(3, 20, 4);
        System.out.println("solution1 = " + solution1);
        long solution2 = clazz.solution1(10, 100, 5);
        System.out.println("solution2 = " + solution2);
        long solution3 = clazz.solution1(2500, 100, 2500);
        System.out.println("solution3 = " + solution3);
    }

    /**
     * 가지고 있는 금액 money
     * 원래 이용료 price
     * 놀이기구 N번째 이용 시 price * count
     *
     * price 3, money 20, count 4
     * 3원짜리 4번 -> 3, 6, 9, 12 -> 30
     * 30 - 20 = 10원 부족
     */
    public long solution(int price, int money, int count) {
        int total = 0;
        for (int i = 1; i <= count; i++) {
            total += price * i;
        }
        return money - total >= 0 ? 0 : total - money;
    }

    /**
     * 놀이기구 n번째 이용 시 price * count
     * 3원 4번 -> 3 6 9 12 -> 30
     * 1+2+3+4 횟수 먼저 더해서 금액 곱하면 더 빠른가
     *
     * 반환값 long인 이유가 있었음
     */
    public long solution2(int price, int money, int count) {
        long cnt = count * (count + 1) / 2;
        long total = cnt * price;
        return money - total >= 0 ? 0 : total - money;
    }

    public long solution1(int price, int money, int count) {
        return Math.max((long) (count * (count + 1) / 2) * price, 0);
    }
}
