package programmers.level1;

public class Cards {
    public static void main(String[] args) {
        Cards cards = new Cards();
        String solution1 = cards.solution(
                new String[]{"i", "drink", "water"},
                new String[]{"want", "to"},
                new String[]{"i", "want", "to", "drink", "water"}
        );

        String solution2 = cards.solution(
                new String[]{"i", "water", "drink"},
                new String[]{"want", "to"},
                new String[]{"i", "want", "to", "drink", "water"}
        );

        String solution3 = cards.solution(
                new String[]{"c", "d", "e"},
                new String[]{"a", "b"},
                new String[]{"a", "b", "c", "d"}
                // b가 두 번 더 비교됨 -> 하지만 겹치는 원소 없기 때문에 상관없긴 함
        );

        System.out.println("solution1 = " + solution1); // "YES"
        System.out.println("solution2 = " + solution2); // "NO"
        System.out.println("solution3 = " + solution3);

    }

    /**
     * 카드 뭉치에서 카드를 한 장씩 사용(앞에서부터, 재사용 X)
     * 서로 다른 단어만 존재
     * goal 원소는 cards1, cards2의 원소들로만 이루어짐
     * goal.length <= cards1.length + cards2.length
     * 순서대로 카드를 뽑아서 사용했을 때 goal 문장을 만들 수 있는가
     *
     * 리스트 하나 만들어서 하나씩 채워보는 방식
     * ["i", "drink", "water"] ["want", "to"] ["i", "want", "to", "drink", "water"]
     * ["i", "water", "drink"] ["want", "to"] ["i", "want", "to", "drink", "water"]
     * cards1[0], cards2[0]을 goal과 비교 -> 리스트를 굳이 만들 필요가?
     */

    public String solution(String[] cards1, String[] cards2, String[] goal) { // 최종
        int count1 = 0;
        int count2 = 0;

        for (String s : goal) {
            if (count1 < cards1.length && s.equals(cards1[count1])) {
                count1++;
            } else if (count2 < cards2.length && s.equals(cards2[count2])) {
                count2++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }

    public String solution2(String[] cards1, String[] cards2, String[] goal) {
        /**
         * if문 조건 순서만 바꿨는데 문제생김
         * &&는 앞의 조건이 false면 뒤의 조건은 확인하지 않음
         */
        int count1 = 0;
        int count2 = 0;

        for(String s : goal){
            if(s.equals(cards1[count1]) && count1 < cards1.length) {
                count1 ++;
                System.out.println("count1 = " + count1);
            } else if (s.equals(cards2[count2]) && count2 < cards2.length) {
                count2++;
                System.out.println("count2 = " + count2);
            } else {
                return "No";
            }
        }
        return "Yes";
    }

    public String solution1(String[] cards1, String[] cards2, String[] goal) {

        int count1 = 0;
        int count2 = 0;

        for (String s : goal) {
            if (s.equals(cards1[count1])) {
                if (count1 + 1 < cards1.length) { // 배열 크기 초과 방지
                    count1++;
                }
            } else if (s.equals(cards2[count2])) {
                if (count2 + 1 < cards2.length) {
                    count2++;
                }
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
