package programmers.level1;

public class CaesarsPwd {
    public static void main(String[] args) {
        CaesarsPwd clazz = new CaesarsPwd();
        String solution1 = clazz.solution("AB", 1);
        String solution2 = clazz.solution("Y Z", 3);
        String solution3 = clazz.solution("a B z", 4);
        String solution4 = clazz.solution("abcdefghijklmnopqrstuvwxyz", 1);
        String solution5 = clazz.solution("abcdefghijklmnopqrstuvwxyz".toUpperCase(), 1);

        System.out.println("solution1 = " + solution1); // BC
        System.out.println("solution2 = " + solution2); // a
        System.out.println("solution3 = " + solution3); // e F d
        System.out.println("solution4 = " + solution4);
        System.out.println("solution5 = " + solution5);
    }

    /**
     * 시저암호: n만큼 s를 밀어서 다른 알파벳으로 바꾸는 암호화 방식
     * ex) AB, 1 -> BC
     *
     */
    public String solution(String s, int n) {
        char[] charArray = s.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (char c : charArray) {
            if (c == ' ') {
                builder.append(' ');
                continue;
            }

            char newChar = (char) (c + n);
            if (c >= 'A' && c <= 'Z') {
                if (newChar > 'Z') {
                    newChar -= 26;
                }
            }
            if (c >= 'a' && c <= 'z') { // Character.isLowerCase(c)
                if (newChar > 'z') {
                    newChar -= 26;
                }
            }
            builder.append(newChar);

//            if (!(c + n >= 'a' && c + n <= 'z') && !(c + n >= 'A' && c + n <= 'Z')) {
//                builder.append(Character.toString(c + n - 26));
//                continue;
//            }
//            builder.append(Character.toString(c + n));
        }
        return builder.toString();
    }
}
