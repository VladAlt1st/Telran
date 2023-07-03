package Tasks11_20;

import java.util.List;

public class Task17 {

    // Дан список чисел. Необходимо найти среднее значение всех уникальных чисел.

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 5, 3, 5);

        list.stream()
                .distinct()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(System.out::println);
    }
}
