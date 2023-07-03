package Tasks11_20;

import java.util.Comparator;
import java.util.List;

public class Task18 {

    // Дан список слов. Необходимо найти самое длинное слово с четной длиной.

    public static void main(String[] args) {
        List<String> list = List.of("abstract", "world", "123", "private", "int", "public", "binary");

        list.stream()
                .filter(s -> s.length() % 2 == 0)
                .max(Comparator.comparing(String::length))
                .ifPresent(System.out::println);
    }
}
