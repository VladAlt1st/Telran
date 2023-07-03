package Tasks21_30;

import java.util.List;

public class Task29 {

    // Дан список чисел. Необходимо найти три наименьших числа и вывести результат.

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 6, -4, -3, 10, 0, 11);

        list.stream()
                .sorted()
                .limit(3)
                .forEach(System.out::println);
    }
}
