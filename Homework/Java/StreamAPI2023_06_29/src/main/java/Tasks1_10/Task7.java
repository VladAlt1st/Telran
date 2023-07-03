package Tasks1_10;

import java.util.Comparator;
import java.util.List;

public class Task7 {

    // Дан список строк. Необходимо оставить только уникальные символы из всех строк
    // и вывести их в алфавитном порядке.

    public static void main(String[] args) {
        List<String> list = List.of("abstract", "world", "123", "Anatomy", "int", "public", "binary");

        list.stream()
                .flatMapToInt(String::chars)
                .mapToObj(i -> String.valueOf((char) i))
                .distinct()
                .sorted(Comparator.comparing(String::toLowerCase))
                .forEach(c -> System.out.print(c + " "));
    }
}
