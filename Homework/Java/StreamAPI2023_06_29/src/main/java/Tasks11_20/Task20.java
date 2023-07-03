package Tasks11_20;

import java.util.List;
import java.util.stream.Collectors;

public class Task20 {

    // Дан список слов. Необходимо проверить, являются ли они палиндромами, и вывести результат.

    public static void main(String[] args) {
        List<String> list = List.of("abstract", "abba", "12321", "private", "int", "anna", "binary");

        System.out.println(list.stream().allMatch(s -> s.contentEquals(new StringBuilder(s).reverse())));

        list.stream()
                .collect(Collectors.partitioningBy(
                                s -> s.contentEquals(new StringBuilder(s).reverse())
                ))
                .entrySet()
                .forEach(System.out::println);
    }
}
