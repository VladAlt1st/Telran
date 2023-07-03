package Tasks1_10;

import java.util.List;

public class Task1 {

    // Дан список строк. Необходимо отфильтровать строки, длина которых больше 3 символов,
    // преобразовать их в верхний регистр, удалить повторяющиеся и вывести результат в отсортированном порядке.

    public static void main(String[] args) {
        List<String> list = List.of("abstract", "world", "123", "private", "int", "public", "binary");

        list.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
