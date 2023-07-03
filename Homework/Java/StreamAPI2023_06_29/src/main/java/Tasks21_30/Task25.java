package Tasks21_30;

import java.util.List;

public class Task25 {

    // Дан список чисел. Необходимо найти сумму всех четных чисел, которые являются положительными.

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 6, -4, -3, 10, 0, 11);

        int sumPositive = list.stream()
                .filter(i -> i > 0 && i % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sumPositive);

        list.stream()
                .filter(i -> i > 0 && i % 2 == 0)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }
}
