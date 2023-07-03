package Tasks1_10;

import java.util.*;
import java.util.stream.Collectors;

public class Task9 {

    // Дан список слов. Необходимо отфильтровать слова, состоящие только из букв,
    // разделить их на гласные и согласные, и вывести результат.

    public static void main(String[] args) {
        List<String> list = List.of("abstract", "world", "123", "private", "int", "public", "binary");

        list.stream()
                .filter(s -> s.matches("[a-zA-Z]+"))
                .collect(Collectors.groupingBy(
                        s -> s,
                        Collectors.flatMapping(
                                s -> s.chars().mapToObj(c -> String.valueOf((char)c)),
                                Collectors.partitioningBy(
                                        c -> c.matches("[aeiouAEIOU]")
                                )
                        )))
                .entrySet()
                .forEach(System.out::println);
    }
}
