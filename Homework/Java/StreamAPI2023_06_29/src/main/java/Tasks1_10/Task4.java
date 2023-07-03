package Tasks1_10;

import java.util.List;

public class Task4 {

    // Дан список чисел. Необходимо найти наименьшее число, больше 0.

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 6, -4, -3, 10, 0, 11);

        list.stream()
                .filter(i -> i > 0)
                .min(Integer::compareTo)
                .ifPresent(System.out::println);
    }
}
