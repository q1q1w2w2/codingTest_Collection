package level1;

public class StrHandleBasic {
    public static void main(String[] args) {
        StrHandleBasic clazz = new StrHandleBasic();
        boolean solution1 = clazz.solution("a234");
        System.out.println("solution1 = " + solution1);

        boolean solution2 = clazz.solution("1234");
        System.out.println("solution2 = " + solution2);

        boolean solution3 = clazz.solution("12341");
        System.out.println("solution3 = " + solution3);

        boolean solution4 = clazz.solution("123411");
        System.out.println("solution4 = " + solution4);
    }

    /**
     * 문자열의 길이가 4, 6이고, 숫자로만 구성되어있으면 true
     */
    public boolean solution1(String s) {
        if (s.length() == 4 || s.length() == 6) {
            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                int ascii = c;
                if (ascii < '0' || ascii > '9') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
//            return s.matches("(^[0-9]*$)");
            return s.matches("(^[0-9]*$)");
        }
        return false;
    }

    public boolean solution3(String s) {
        return (s.length() == 4 || s.length() == 6) && (s.split("[0-9]").length <= 0);
    }


    // 좋은 방법 아님
    public boolean solution2(String s) {
        if (s.length() == 4 || s.length() == 6) {
            try {
                int i = Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
}
