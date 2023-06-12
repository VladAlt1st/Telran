package org.example;

import java.util.HashSet;
import java.util.Set;

public class SetTask {
    public static void main(String[] args) {
        int[] first = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] second = {1, 3, 5, 6, 9, 10};
        System.out.println(findIntersections(first, second));
    }


    // TODO:  Напишите метод, который принимает два массива int и возвращает Set,
    //     содержащий элементы, которые присутствуют и в первом, и во втором массивах.
    private static Set<Integer> findIntersections(int[] first, int[] second) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> tmp = new HashSet<>();

        for (int i : first) {
            tmp.add(i);
        }
        for (int i : second) {
            if (!tmp.add(i)) {
                set.add(i);
            }
        }
        /*Set<Integer> set = new HashSet<>(Arrays.stream(first).boxed().toList());
        set.retainAll(Arrays.stream(second).boxed().toList());*/

        return set;
    }

    // TODO:  Напишите метод, который принимает массив int и возвращает количество уникальных элементов в этом массиве,
    //     используя Set для хранения уникальных значений.
    private static int countUnique(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int j : arr) {
            set.add(j);
        }
        return set.size();

        //return new HashSet<>(Arrays.stream(arr).boxed().toList()).size();
    }
}
