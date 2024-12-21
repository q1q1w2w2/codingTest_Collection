package test;

public class PrimitiveTest {

    public static void main(String[] args) {
        int v = 10;
        PrimitiveTest clazz = new PrimitiveTest();
        clazz.add(v);
        System.out.println("v = " + v);
    }

    private void add(int num) {
        num++;
    }
    // 리턴 안했으니까 v는 그냥 10이 맞지
    // v = v + 1 한거면 모를까
}
