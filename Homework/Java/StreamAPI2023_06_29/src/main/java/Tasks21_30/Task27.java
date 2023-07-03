package Tasks21_30;

import java.util.List;
import java.util.stream.Collectors;

public class Task27 {

    // Дан список слов. Необходимо разделить их на две группы:
    // одна группа - слова с длиной менее или равной 4 символам, другая группа - слова с длиной более 4 символов.
    // После этого подсчитать количество слов в каждой группе и вывести результат.

    public static void main(String[] args) {
        List<String> list = List.of("abstract", "world", "123", "private", "int", "public", "binary");

        list.stream()
                .collect(Collectors.partitioningBy(
                        s -> s.length() <= 4,
                        Collectors.counting()
                ))
                .entrySet()
                .forEach(System.out::println);
    }
}
