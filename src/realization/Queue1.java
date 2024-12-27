package realization;

import java.util.Arrays;

public class Queue1 {
    int SIZE = 10;
    int head;
    int tail;
    int[] queue;

    public Queue1() {
        head = 0;
        tail = 0;
        queue = new int[SIZE];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        if (tail == SIZE) {
            return true;
        }
        return false;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("IS FULL");
            return;
        }
        queue[tail++] = value;
        System.out.println("queue = " + Arrays.toString(queue));
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("IS EMPTY");
            return -1;
        }
        int result = queue[head++];
        System.out.println("queue = " + Arrays.toString(queue));
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("IS EMPTY");
            return -1;
        }
        System.out.println("queue = " + Arrays.toString(queue));
        return queue[head];
    }

    public int size() {
        return tail - head + 1;
    }

    public static void main(String[] args) {
        Queue1 queue = new Queue1();
        for (int i = 1; i < 20; i++) {
            queue.push(i);
        }
        for (int i = 1; i < queue.size(); i++) {
            System.out.println(queue.pop());
        }

    }
}
