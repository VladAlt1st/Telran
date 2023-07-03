package Tasks21_30;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task23 {

    // Дан список строк. Необходимо объединить все символы из всех строк,
    // удалить дубликаты и отсортировать их в лексикографическом порядке.

    public static void main(String[] args) {
        List<String> list = List.of("abstract", "world", "123", "private", "int", "public", "binary");

        String str = list.stream()
                .flatMapToInt(String::chars)
                .mapToObj(i -> String.valueOf((char) i))
                .distinct()
                .sorted(Comparator.comparing(String::toLowerCase))
                .collect(Collectors.joining());
        System.out.println(str);
    }
}
