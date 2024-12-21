package level1;

public class CoverPhoneNum {
    public static void main(String[] args) {
        CoverPhoneNum clazz = new CoverPhoneNum();
        String solution1 = clazz.solution("01033334444");
        System.out.println("solution1 = " + solution1);
        String solution2 = clazz.solution2("01033334444");
        System.out.println("solution2 = " + solution2);
    }

    /**
     * 01033334444 -> *******4444
     * phone_number은 4~20 문자열
     * 뒷 4자리 제외한 나머지를 *로
     */
    public String solution(String phone_number) {
        StringBuilder builder = new StringBuilder();

        int size = phone_number.length();
        for (int i = 0; i < phone_number.length() - 4; i++) {
            builder.append("*");
        }
        builder.append(phone_number.substring(size - 4, size));
        return builder.toString();
    }

    public String solution2(String phone_number) {
        String num = phone_number.substring(phone_number.length() - 4, phone_number.length());
        return "*".repeat(phone_number.length() - 4) + num;
    }

    public String solution3(String phone_number) {
        char[] ch = phone_number.toCharArray();
        for (int i = 0; i < ch.length - 4; i++) {
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }

    public String solution4(String phone_number) {
        return phone_number.replaceAll(".(?=.{4})", "*");
    }
}
