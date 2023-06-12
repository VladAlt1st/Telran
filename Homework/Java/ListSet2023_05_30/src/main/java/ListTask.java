import java.util.ArrayList;
import java.util.List;

public class ListTask {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 5, 4, 6, 4, 2, 2, 6, 7};
        System.out.println(removeDuplicates(arr));
        System.out.println(revers(arr));
    }

    // TODO:  Напишите метод, который принимает массив int и возвращает ArrayList,
    //     содержащий все уникальные элементы исходного массива, сохраняя их порядок.
    private static List<Integer> removeDuplicates(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (int i : arr) {
            if (!list.contains(i)) {
                list.add(i);
            }
        }
        return list;

        //return Arrays.stream(arr).distinct().toList();
    }

    // TODO:  Напишите метод, который принимает массив int и возвращает ArrayList,
    //     содержащий элементы исходного массива в обратном порядке.
    private static List<Integer> revers(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (int j : arr) {
            list.add(0, j);
        }
        /*Collections.addAll(list, Arrays.stream(arr).boxed().toArray(Integer[] ::new));
        Collections.reverse(list);*/

        return list;
    }
}