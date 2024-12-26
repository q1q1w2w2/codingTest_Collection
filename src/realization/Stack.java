package realization;

import java.util.Arrays;
import java.util.EmptyStackException;

// 스택 구현
public class Stack<T> {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        String pop = stack.pop();
        System.out.println(pop);
    }

    private static final int DEFAULT_CAPACITY = 6;
    private Object[] arr;
    private int top;
    
    public Stack() {
        this.arr = new Object[DEFAULT_CAPACITY]; // 6만큼 배열 생성
        this.top = -1;
    }

    public boolean isFull() {
        return top == arr.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private void resize() {
        int arr_capacity = arr.length - 1;
        // 용량이 꽉 찬 경우
        if (top == arr_capacity) {
            int new_capacity = arr.length * 2;
            arr = Arrays.copyOf(arr, new_capacity);
            return;
        }
        // 크기 다시 줄어들면 스택도 줄이기
        if (top < arr_capacity / 2) {
            int half_capacity = arr.length / 2;
            arr = Arrays.copyOf(arr, Math.max(half_capacity, DEFAULT_CAPACITY));
            return;
        }
    }

    public T push(T value) {
        if (isFull()) {
            resize();
        }
        arr[++top] = value;
        return value;
    }

    /**
     * arr의 요소는 Object이므로 제네릭 T로 변환해야 하는데,
     * 이 과정에서 경고 발생하는 것을 무시
     * 제네릭 자체가 확인되지 않은 애매한 타입이라 발생함
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = (T) arr[top];
        arr[top] = null;
        top--;
        resize(); // 빈공간 많아지면 리사이징
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) arr[top];
    }

    // 스택 맨 위부터 순회하여 value의 위치를 구함
    public int search(T value) {
        for (int i = top; i >= 0; i--) {
            if (arr[i].equals(value)) {
                return top - i + 1;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
