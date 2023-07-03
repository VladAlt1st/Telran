package Tasks21_30;

import java.util.List;
import java.util.stream.Collectors;

public class Task22 {

    // Дан список строк. Необходимо объединить все строки в одну строку,
    // добавив префикс ">>" и суффикс "<<" к каждой строке.

    public static void main(String[] args) {
        List<String> list = List.of("abstract", "world", "123", "anatomy", "sad", "bottom");

        String str = list.stream()
                .map(s -> ">>" + s + "<<")
                .collect(Collectors.joining());
        System.out.println(str);
    }
}
