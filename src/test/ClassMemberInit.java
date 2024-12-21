package test;

public class ClassMemberInit {
    static int staticVar = initStatic();
    int instanceVar = initInstance();

    private static int initStatic() {
        System.out.println("static 변수 초기화");
        return 10;
    }

    private int initInstance() {
        System.out.println("인스턴스 변수 초기화");
        return 20;
    }

    public ClassMemberInit() {
        System.out.println("생성자 실행");
    }

    public static void main(String[] args) {
        System.out.println("객체 생성 시작");
        ClassMemberInit classMemberInit = new ClassMemberInit();
    }
}
