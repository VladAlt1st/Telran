package Tasks21_30;

import java.util.List;

public class Task26 {

    // Дан список чисел. Необходимо найти второе минимальное число среди уникальных чисел.

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 6, -4, -3, 10, -4, 11);

        list.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
