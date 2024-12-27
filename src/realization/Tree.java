package realization;

public class Tree {

    public static class Node {
        Object data;
        Node left;
        Node right;

        // 루트 노드 생성
        public Node(Object data) {
            this.data = data;
            left = null;
            right = null;
        }

        public void makeLeftSubTree(Node node) {
            if (left == null) {
                left = node;
            } else {
                System.out.println("왼쪽 노드가 비어있지 않습니다.");
            }
        }

        public void makeRightSubTree(Node node) {
            if (right == null) {
                right = node;
            } else {
                System.out.println("오른쪽 노드가 비어있지 않습니다.");
            }
        }

        public Object getData() {
            return data;
        }

        public Node getLeftSubTree() {
            return left;
        }

        public Node getRightSubTree() {
            return right;
        }
    }

    public static void main(String[] args) {
        Node T1 = new Node(1);
        Node T2 = new Node(2);
        Node T3 = new Node(3);
        Node T4 = new Node(4);

        T1.makeLeftSubTree(T2);
        T1.makeRightSubTree(T3);
        T2.makeLeftSubTree(T4);

        System.out.println(T1.getLeftSubTree().getLeftSubTree().getData());

    }

}
