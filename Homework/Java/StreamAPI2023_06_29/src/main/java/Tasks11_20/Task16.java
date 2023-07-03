package Tasks11_20;

import java.util.List;
import java.util.stream.Collectors;

public class Task16 {

    // Дан список слов. Необходимо подсчитать количество символов в каждом слове и вывести результат.

    public static void main(String[] args) {
        List<String> list = List.of("abstract", "world", "123", "private", "int", "public", "binary");

        list.stream()
                .collect(Collectors.groupingBy(
                        str -> str,
                        Collectors.mapping(
                                String::length,
                                Collectors.toList()
                        )
                ))
                .entrySet()
                .forEach(System.out::println);

        list.stream()
                .collect(Collectors.groupingBy(
                        String::length
                ))
                .entrySet()
                .forEach(System.out::println);
    }
}
