package Tasks1_10;

import java.util.List;

public class Task2 {

    // Дан список слов. Необходимо найти среднюю длину слов, начинающихся с буквы "A".

    public static void main(String[] args) {
        List<String> list = List.of("Abstract", "world", "123", "Anatomy", "int", "public", "binary");

        list.stream()
                .filter(s -> s.startsWith("A"))
                .mapToInt(String::length)
                .average()
                .ifPresent(System.out::println);
    }
}
