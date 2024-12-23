package test.innerouter;

public class OuterClass {
    public String outerString = "Hello World";

    public void testOuterMethod() {
        int innerField = InnerClass.innerField;
    }

    public static class InnerClass {
        public static int innerField;

        public void testInnerMethod() {
            OuterClass outerClass = new OuterClass();
            String outerString1 = outerClass.outerString;
        }

    }
    
}
