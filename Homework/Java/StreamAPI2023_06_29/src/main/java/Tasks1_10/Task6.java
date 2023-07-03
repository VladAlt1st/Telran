package Tasks1_10;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Task6 {

    // Даны два списка чисел. Необходимо объединить их в один список,
    // отсортировать по убыванию и удалить повторяющиеся элементы.

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 3, 6, -4, -3, 10, 0, 11);
        List<Integer> list2 = List.of(4, 8, 3, -6, -3, 11, 1, -5);

        List<Integer> list = Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(list);
    }
}
