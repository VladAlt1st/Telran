package Tasks1_10;

import java.util.List;

public class Task5 {

    // Дан список чисел. Необходимо найти сумму квадратов всех положительных чисел.

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 6, -4, -3, 10, 0, 11);

        int sumSquares = list.stream()
                .filter(i -> i > 0)
                .mapToInt(i -> i * i)
                .sum();
        System.out.println(sumSquares);

        list.stream()
                .filter(i -> i > 0)
                .map(i -> i * i)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }
}
