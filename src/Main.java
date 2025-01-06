import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.of(2025, 1, 1, 0, 0, 0);
        System.out.println(date.getMonth().toString());
    }
}