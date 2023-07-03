package Tasks11_20;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task13 {

    // Даны два списка чисел. Необходимо найти разность множеств(элементы, присутствующие только в одном из списков)
    // и вывести результат.

    public static void main(String[] args) {
        List<Integer> list1 = List.of(1, 2, 3, -4, -3, 11, 0);
        List<Integer> list2 = List.of(1, 2, 3, -6, -3, 11, 5);

        Set<Integer> differenceSet = Stream.concat(list1.stream(), list2.stream())
                .filter(i -> !(list1.contains(i) && list2.contains(i)))
                .collect(Collectors.toSet());
        System.out.println(differenceSet);

        List<Set<Integer>> differenceSets = Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.teeing(
                        Collectors.filtering(i -> !list1.contains(i), Collectors.toSet()),
                        Collectors.filtering(i -> !list2.contains(i), Collectors.toSet()),
                        (c1, c2) -> {
                            List<Set<Integer>> difference = new ArrayList<>();
                            difference.add(c2);
                            difference.add(c1);
                            return difference;
                        }
                ));
        System.out.println(differenceSets);
    }
}
