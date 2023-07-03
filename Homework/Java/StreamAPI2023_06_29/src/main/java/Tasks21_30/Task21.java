package Tasks21_30;

import java.util.List;

public class Task21 {

    // Дан список чисел. Необходимо найти максимальное четное число.

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 6, -4, -3, 10, 0, 11);

        list.stream()
                .filter(i -> i % 2 == 0)
                .max(Integer::compareTo)
                .ifPresent(System.out::println);
    }
}
