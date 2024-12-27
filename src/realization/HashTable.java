package realization;

import java.util.LinkedList;

public class HashTable {
    class Node {
        String key;
        String value;

        public Node(String value, String key) {
            super();
            this.value = value;
            this.key = key;
        }

        // getter
        String value() {
            return value;
        }

        // setter
        void value(String value) {
            this.value = value;
        }
    }

    java.util.LinkedList<Node>[] data;

    HashTable(int size) {
        this.data = new LinkedList[size];
    }

    int getHashCode(String key) {
        int hashCode = 0;
        for (char c : key.toCharArray()) {
            hashCode += c;
        }
        return hashCode;
    }

    int convertToIndex(int hashCode) {
        return hashCode % this.data.length;
    }

    Node searchKey(LinkedList<Node> list, String key) {
        if (list == null) {
            return null;
        }
        for (Node node : list) {
            if (node.key.equals(key)) {
                return node;
            }
        }
        return null;
    }

    void put(String key, String value) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);

        System.out.println(key + ", hashcode(" + hashCode + "), index(" + index + ")");

        LinkedList<Node> list = data[index];

        if(list == null) {
            list = new LinkedList<Node>();
            data[index] = list;
        }

        Node node = searchKey(list, key);

        if (node == null) {
            list.addLast(new Node(key, value));
        } else {
            node.value(value);
        }
    }

    String get(String key) {
        int hashCode = getHashCode(key);
        int index = convertToIndex(hashCode);
        LinkedList<Node> list = data[index];

        Node node = searchKey(list, key);
        return node == null ? "Not Found" : node.value();
    }

    public static void main(String[] args) {
        HashTable h = new HashTable(3);

        h.put("sung", "She is pretty");
        h.put("jin", "She is a model");
        h.put("hee", "She is an angel");
        h.put("min", "She is cute");

        //덮어쓰기
        h.put("sung", "She is beautiful");

        System.out.println(h.get("sung"));
        System.out.println(h.get("jin"));
        System.out.println(h.get("hee"));
        System.out.println(h.get("min"));

        //없는 데이터 호출
        System.out.println(h.get("jae"));
    }
}
