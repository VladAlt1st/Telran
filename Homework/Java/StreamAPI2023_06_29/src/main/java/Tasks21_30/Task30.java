package Tasks21_30;

import java.util.List;

public class Task30 {

    // Дан список строк. Необходимо проверить, содержит ли хотя бы одна строка подстроку "an" и вывести результат.

    public static void main(String[] args) {
        List<String> list = List.of("abstract", "world", "123", "anatomy", "int", "public", "binary");

        System.out.println(list.stream().anyMatch(s -> s.contains("an" )));
    }
}
