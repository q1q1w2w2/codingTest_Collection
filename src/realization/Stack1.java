package realization;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack1<T> {
    /**
     * stack 필요 메서드
     * resize
     * push
     * pop
     * peek
     * toString
     * isFull
     * isEmpty
     * search(index)
     */

    public static int DEFAULT_CAPACITY = 10;
    private Object[] arr;
    private int top;

    public Stack1() {
        this.arr = new Object[DEFAULT_CAPACITY];
        this.top = -1;
    }

    public boolean isFull() {
        return top == arr.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private void resize() {
        if (top == arr.length - 1) {
            arr = Arrays.copyOf(arr, arr.length * 2);
            return;
        }

        if (top < arr.length / 2) {
            arr = Arrays.copyOf(arr, Math.max(arr.length / 2, DEFAULT_CAPACITY));
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

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = (T) arr[top];
        arr[top--] = null;
        resize();
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) arr[top];
    }

    public int indexOf(T value) {
        for (int i = top; i >= 0; i++) {
            if (arr[top].equals(value)) {
                return top - i - 1;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        Stack1<Integer> stack = new Stack1<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
