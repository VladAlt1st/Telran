public class Task2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 10, 10, 11, 15};
        System.out.println(binarySearchRec(arr, 16, 0, arr.length - 1));
        System.out.println(binarySearchRec(arr, 2, 0, arr.length - 1));
    }

    /**
     * Реализовать рекурсивный алгоритм бинарного поиска. Используйте стратегию "разделяй и властвуй".
     */
    private static int binarySearchRec(int[] arr, int key, int low, int high) {
        if (low > high) return -1;

        int mid = (high + low) / 2;

        if (key > arr[mid]) {
            return binarySearchRec(arr, key, mid + 1, high);
        } else if (key < arr[mid]) {
            return binarySearchRec(arr, key, low, mid - 1);
        } else {
            return mid;
        }
    }
}
