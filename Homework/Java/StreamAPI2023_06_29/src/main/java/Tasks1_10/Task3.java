package Tasks1_10;

import java.util.List;
import java.util.stream.Collectors;

public class Task3 {

    // Дан список слов. Необходимо сгруппировать их по длине и вывести результат.

    public static void main(String[] args) {
        List<String> list = List.of("abstract", "world", "123", "private", "int", "public", "binary");

        list.stream()
                .collect(Collectors.groupingBy(String::length))
                .entrySet()
                .forEach(System.out::println);
    }
}
