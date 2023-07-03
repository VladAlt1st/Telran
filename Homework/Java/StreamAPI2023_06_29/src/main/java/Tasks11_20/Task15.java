package Tasks11_20;

import java.util.List;

public class Task15 {

    // Дан список строк. Необходимо отфильтровать строки,
    // которые начинаются с префикса "pre" и заканчиваются суффиксом "post".

    public static void main(String[] args) {
        List<String> list = List.of("abstract", "pre_world_post", "pre123post", "private_post", "pre_int", "public", "binary");

        list.stream()
                .filter(s -> s.startsWith("pre") && s.endsWith("post"))
                .forEach(System.out::println);
    }
}
