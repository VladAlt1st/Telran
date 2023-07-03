package Tasks1_10;

import java.util.Comparator;
import java.util.List;

public class Task8 {

    // Дан список чисел. Необходимо найти второе максимальное число.

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 6, -4, -3, 10, 0, 11);

        list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
