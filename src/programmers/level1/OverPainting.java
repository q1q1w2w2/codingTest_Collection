package programmers.level1;

public class OverPainting {
    public static void main(String[] args) {
        /**
         * 페인트가 칠해진 길이 n 미터
         * 근데 페인트 벗겨져서 덧칠하기로 함
         * 전체를 새로 칠하는 대신, 구역을 나누어 일부만 칠함
         * 벽을 1미터 길이의 구역 n개로 나누고
         * 각 구역 왼쪽부터 순서대로 1부터 n까지 번호를 붙임
         * 그리고 페인트를 다시 칠할 구역을 정함
         *
         * 벽에 페인트를 칠하는 롤러 길이는 m미터
         * 롤러로 벽에 페인트를 한 번 칠하는 규칙은
         * 1. 롤러가 벽에서 벗어나면 안됨
         * 2. 구역의 일부분만 포함되도록 칠하면 안됨
         * 페인트를 모두 칠하기 위한 횟수 최소
         *
         * n = 8, m = 4, section = [2, 3, 6], result = 2
         * 2번, 3번, 6번 영역에 페인트 칠해야 함
         * 롤러 길이가 4m 이므로 한 번의 페인트칠로 연속된 4개의 구역을 칠하게 됨
         *
         * n: 총 벽의 길이
         * m: 롤러의 길이
         * section: 칠해야 하는 곳
         *
         * 2, 3, 6 -> 5m
         *
         * n = 10, m = 3, section = [1, 5, 7, 8]
         * 1을 위해 한번(1,2,3)
         * 5와 7을 동시에(5,6,7)
         * 8을 위해 한번(8,9,10)(6,7,8).. 3번
         * 1,5,7,8 -> 8m
         *
         * n = 10, m = 4, section = [1, 2, 3, 4]
         * 1번
         * 1,2,3,4 -> 4m
         *
         * n = 10, m = 1, section = [1, 2, 3, 4]
         * 4번
         * 1,2,3,4 -> 4m
         *
         * n = 10, m = 4, section = [1, 2, 3, 5]
         * 2번
         * 1,2,3,5 -> 5m
         *
         * 문제에서 총 벽의 길이가 필요한가?
         * 그냥 section 총 길이 계산하고 m으로 나눈 후 올림?
         *
         * 한칸씩 가다가 칠해야하는 곳 나오면 롤러 길이만큼 점프
         */

        OverPainting overPainting = new OverPainting();
        int solution1 = overPainting.solution(8, 4, new int[]{2, 3, 6});
        System.out.println("solution1 = " + solution1);

        int solution2 = overPainting.solution(5, 4, new int[]{1, 3});
        System.out.println("solution2 = " + solution2);

        int solution3 = overPainting.solution(4, 1, new int[]{1, 2, 3, 4});
        System.out.println("solution3 = " + solution3);

        int solution4 = overPainting.solution(10, 4, new int[]{1, 2, 3, 10});
        System.out.println("solution4 = " + solution4);

        int solution5 = overPainting.solution(10, 1, new int[]{1, 2, 3, 10});
        System.out.println("solution5 = " + solution5);
    }

    public int solution(int n, int m, int[] section){
        if (m == 1) {
            return section.length;
        }

        int count = 0;
        int lastPainted = 0;

        for (int pos : section) {
            if (pos > lastPainted) {
                count++;
                lastPainted = pos + m - 1;
            }
        }
        return count;

//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 0; j < section.length; j++) {
//                if (i == section[j]) {
//                    count++;
//                    i += m;
//                }
//            }
//        }
    }

}
