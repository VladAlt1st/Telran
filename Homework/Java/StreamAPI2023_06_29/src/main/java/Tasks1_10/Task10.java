package Tasks1_10;

import java.util.List;
import java.util.stream.Collectors;

public class Task10 {

    // Дан список строк. Необходимо удалить пустые строки,
    // объединить оставшиеся строки в одну строку, разделенную запятой.

    public static void main(String[] args) {
        List<String> list = List.of("abstract", "", "123", "private", "", "public", "binary");

        String str = list.stream()
                .filter(s -> !"".equals(s))
                .collect(Collectors.joining(", "));
        System.out.println(str);

        list.stream()
                .filter(s -> !"".equals(s))
                .reduce((s1, s2) -> s1 + ", " + s2)
                .ifPresent(System.out::println);
    }
}
