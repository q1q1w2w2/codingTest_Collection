package test;

import java.util.*;
import java.util.stream.Collectors;

public class SortTest {
    public static void main(String[] args) {
//        arraySort();
        listSort();
//        listSortStream();
//        mapSort();
    }

    private static void arraySort() {
        int[] numbers = {5, 2, 7, 9, 1};
        Arrays.sort(numbers);
        System.out.println("numbers = " + Arrays.toString(numbers));

        Integer[] boxedNumbers = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            boxedNumbers[i] = numbers[i];
        }

        Arrays.sort(boxedNumbers, (a, b) -> b - a);
        System.out.println("boxedNumbers = " + Arrays.toString(boxedNumbers));
    }

    private static void listSort() {
        List<User> users = Arrays.asList(
                new User("Bob", 12),
                new User("Alice", 40),
                new User("Alice", 10),
                new User("Charlie", 23)
        );
//        System.out.println("users = " + users);

        users.sort(Comparator
                .comparing(User::getUsername)
                .thenComparing(User::getAge, Comparator.reverseOrder()));
        System.out.println("users = " + users);
//        List<User> users = new ArrayList<>();
//        users.add(new User("Bob", 12));
//        users.add(new User("Alice", 40));
//        users.add(new User("Alice", 11));
//        users.add(new User("Charlie", 23));
//        System.out.println("users = " + users);
//
//        users.sort(Comparator
//                .comparing(User::getUsername)
//                .thenComparing(User::getAge));
//        System.out.println("users = " + users);
    }

    private static void listSortStream() {
        List<User> users = new ArrayList<>();
        users.add(new User("Bob", 12));
        users.add(new User("Alice", 40));
        users.add(new User("Alice", 11));
        users.add(new User("Charlie", 23));
        System.out.println("users = " + users);

        List<User> sortUsers = users.stream()
                .sorted(Comparator.comparing(User::getUsername).thenComparing(User::getAge))
                .collect(Collectors.toList());
        System.out.println("sortUsers = " + sortUsers);
    }

    private static void mapSort() {
        Map<String, Integer> users = new HashMap<>();
        users.put("Bob", 12);
        users.put("Alice", 40);
        users.put("Charlie", 23);

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(users.entrySet());
        entryList.sort(Comparator
                .comparing(Map.Entry<String, Integer>::getValue)
//                .thenComparing(Map.Entry::getKey)
        );

        System.out.println("entryList = " + entryList);
    }

    static class User {

        String username;
        int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }

        public String getUsername() {
            return username;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
