package GenericTasks;

public class GenericMethods {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        swap(arr, 0, 5);
        printArray(arr);
    }

    // TODO: Реализуйте параметризированный метод "swap",
    //  который принимает массив элементов и два индекса внутри массива.
    //  Метод должен поменять местами элементы по указанным индексам.
    private static <E> void swap(E[] arr, int first, int second) {
        E tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }

    // TODO: Напишите параметризированный метод "printArray",
    //  который принимает массив элементов и выводит их на консоль.
    //  Метод должен работать с любыми типами данных.
    private static <E> void printArray(E[] arr) {
        for (E e : arr) {
            System.out.println(e);
        }
        //Arrays.stream(arr).forEach(System.out::println);
    }
}
