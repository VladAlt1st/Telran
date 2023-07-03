package Tasks21_30;

import java.util.List;
import java.util.stream.Collectors;

public class Task28 {

    // Дан список строк. Необходимо пропустить первые три символа в каждой строке
    // и объединить оставшиеся символы в одну строку.

    public static void main(String[] args) {
        List<String> list = List.of("abstract", "world", "123", "private", "int", "public", "binary");

        String str = list.stream()
                .map(s -> s.substring(3))
                .collect(Collectors.joining());
        System.out.println(str);

        list.stream()
                .map(s -> s.substring(3))
                .reduce((s1, s2) -> s1 + s2)
                .ifPresent(System.out::println);
    }
}
