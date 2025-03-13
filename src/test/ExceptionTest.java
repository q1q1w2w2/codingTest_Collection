package test;

import java.io.IOException;

public class ExceptionTest {

    public static void main(String[] args) throws IOException {
        try {
            Test test = new Test();
            test.method();
        } catch (IOException e) {
            System.out.println("catch 구문");
        } finally {
            System.out.println("finally 구문");
        }
    }

    static class Test{
        public void method() throws IOException {
            throw new TestException("testException");
        }
    }


    public static class TestException extends RuntimeException {
        public TestException(String message) {
            super(message);
        }
    }
}
