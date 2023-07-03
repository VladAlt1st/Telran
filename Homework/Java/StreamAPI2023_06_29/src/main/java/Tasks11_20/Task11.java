package Tasks11_20;

import java.util.List;

public class Task11 {

    // Дан список слов. Необходимо объединить все символы из всех слов в одну строку.

    public static void main(String[] args) {
        List<String> list = List.of("abstract", "world", "123", "private", "int", "public", "binary");

        System.out.println(String.join(" ", list));

        list.stream()
                .reduce((s1, s2) -> s1 + " " + s2)
                .ifPresent(System.out::println);
    }
}
