package programmers.level1;

public class Babbling {
    public static void main(String[] args) {
        System.out.println(solution2(new String[]{"aya", "yee", "u", "maa"}));
        System.out.println(solution2(new String[]{"ayaaya", "yeaya"}));
    }

    /**
     * "aya", "ye", "woo", "ma"
     * 주어진 배열에서 이 4가지를 조합하여 만들 수 있는 발음만 가능 + 연속해서 같은 발음 불가능(yeye는 안되고, yewooye는 가능)
     * 발음할 수 있는 경우의 수 반환
     *
     * [aya, yee, u, maa] 의 경우, 위 4가지를 조합해서 만들 수 있는 것은 aya 뿐임 -> 1
     */
    public static int solution(String[] babbling) {
        int answer = 0;
        String[] say = {"aya", "ye", "woo", "ma"};

        for (String word : babbling) {
            boolean isValid = true;
            for (String s : say) {
                if (word.contains(s + s)) {
                    isValid = false;
                    break;
                }
                word = word.replace(s, " ");
            }
            if (isValid && word.trim().isEmpty()) {
                answer++;
            }
        }
        return answer;
    }

    public static int solution2(String[] babbling) {
        int answer = 0;
        for (String word : babbling) {
            if (word.contains("ayaaya") || word.contains("yeye") || word.contains("woowoo") || word.contains("ma")) {
                continue;
            }
            word = word.replaceAll("aya|ye|woo|ma", " ");
            if (word.trim().isEmpty()) answer++;
        }
        return answer;
    }
}
