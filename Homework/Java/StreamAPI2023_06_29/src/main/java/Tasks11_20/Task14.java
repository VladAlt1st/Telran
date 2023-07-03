package Tasks11_20;

import java.util.List;
import java.util.stream.Collectors;

public class Task14 {

    // Дан список слов. Необходимо подсчитать количество слов для каждой длины и вывести результат.

    public static void main(String[] args) {
        List<String> list = List.of("abstract", "world", "123", "private", "int", "public", "binary");

        list.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.counting()
                ))
                .entrySet()
                .forEach(System.out::println);
    }
}
