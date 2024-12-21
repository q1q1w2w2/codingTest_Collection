package programmers.level1;

public class FoodFight {
    public static void main(String[] args) {
        FoodFight clazz = new FoodFight();
        String solution1 = clazz.solution(new int[]{1, 3, 4, 6});
        String solution2 = clazz.solution(new int[]{1, 7, 1, 2});

        System.out.println("solution1 = " + solution1); // 1223330333221
        System.out.println("solution2 = " + solution2); // 111303111
    }

    /**
     * 한 명은 오른쪽-왼쪽 / 한 명은 반대로 먹는다
     * 중앙에 물을 배치하고 먼저 먹는 선수가 승리
     * 예) 3가지 음식, 칼로리 낮은 순 - {1, 3, 4, 6} <= 이게 이미 칼로리 낮은 순 배치임
     * 1번 음식 3개, 2번 음식 4개, 3번 음식 6개, 0번(물)일 때 음식의 배치
     * 1223330333221 -> 1번 음식 하나는 못써먹음
     *
     * 예2) {1, 3, 4, 6}
     * 0번 물, 1번 하나 못씀
     * 1223330333221
     *
     */
    public String solution1(int[] food) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < food.length - 1; i++) {
            int remain = (int) Math.floor((double) food[i + 1] / 2);
            while (remain > 0) {
                builder.append(i + 1);
                remain -= 1;
            }
        }
        String first = builder.toString();
        String last = builder.reverse().toString();

        return first + "0" + last;
    }

    public String solution(int[] food) {
//        String answer = "0";
        StringBuilder answer = new StringBuilder("0");
        for (int i = food.length - 1; i > 0; i--) {
            for (int j = 0; j < food[i] / 2; j++) {
//                answer = i + answer + i;
                answer.insert(0, i);
                answer.append(i);
            }
        }
        return answer.toString();
    }
}
