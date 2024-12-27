package realization;

public class Queue {
    int MAX = 1000;
    int head; // pop
    int tail; // push
    int[] queue;

    public Queue() {
        head = tail = 0;
        queue = new int[MAX];
    }

    public boolean isFull() {
        if (tail == MAX - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public int size() {
        return head - tail;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("IS FULL");
            return;
        }
        queue[tail++] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("IS EMPTY");
            return -1;
        }
        return queue[head++];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("IS EMPTY");
            return -1;
        }
        return queue[head];
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(1); // front
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());

    }

}
