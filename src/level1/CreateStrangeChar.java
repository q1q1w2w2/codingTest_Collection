package level1;

public class CreateStrangeChar {
    public static void main(String[] args) {
        CreateStrangeChar create = new CreateStrangeChar();

//        String test = "try hello world";
//        String[] split = test.split(" ");
//        System.out.println("split = " + create.toString(split));
        String solution = create.solution("try hello world");
        System.out.println("solution = " + solution);

        String solution1 = create.solution1("try  hello  world");
        System.out.println("solution1 = " + solution1);
    }

    /**
     * 문자열 s는 한 개 이상의 단어로 구성
     * 각 단어는 하나 이상의 공백으로 구분
     * 각 단어의 짝수 알파벳은 대문자, 홀수는 소문자(인덱스는 0부터 시작)
     * ex) try hello world -> TrY HeLlO WoRlD,
     */
    public String solution(String s) {
        String answer = "";
        String[] split = s.split(" ", -1);
        StringBuilder builder = new StringBuilder();

        for (String string : split) {
            String[] strSplit = string.split("");

            int cnt = 0;
            for (String str : strSplit) {
                if (cnt % 2 == 0) {
                    builder.append(str.toUpperCase());
                } else {
                    builder.append(str.toLowerCase());
                }
                cnt++;
            }
            builder.append(" ");
        }

        builder.setLength(builder.length() - 1);
        return builder.toString();
    }

    public String solution1(String s) {
//        String answer = "";
        String[] array = s.split("");
        int cnt = 0;
        StringBuilder answer = new StringBuilder();

        for (String ss : array) {
//            if (ss.contains(" ")) {
//                cnt = 0; // 공백 만나면 cnt 초기화
//            } else {
//                cnt++;
//            }

//            if (cnt % 2 == 0) {
//                answer.append(ss.toLowerCase());
//            } else {
//                answer.append(ss.toUpperCase());
//            }

            answer.append(cnt % 2 == 0 ? ss.toUpperCase() : ss.toLowerCase());
            cnt = ss.contains(" ") ? 0 : cnt + 1;
        }
        return answer.toString();
    }
}
