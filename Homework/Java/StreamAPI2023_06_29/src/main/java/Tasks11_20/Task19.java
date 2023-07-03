package Tasks11_20;

import java.util.Comparator;
import java.util.List;

public class Task19 {

    // Дан список строк. Необходимо удалить все пробелы в каждой строке,
    // отсортировать их в лексикографическом порядке и вывести результат.

    public static void main(String[] args) {
        List<String> list = List.of("abstract", "world", "1 2 3", "pri va te", "int", "pub lic", "Bi na ry");

        list.stream()
                .map(s -> s.replaceAll(" ", ""))
                .sorted(Comparator.comparing(String::toLowerCase))
                .forEach(System.out::println);
    }
}
