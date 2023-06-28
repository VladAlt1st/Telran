import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Написать самостоятельно сортировку слиянием.
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left == right) return;

        int mid = (right + left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int left, int right) {
        int length = right - left + 1;
        int[] temp = new int[length];
        System.arraycopy(arr, left, temp, 0, length);

        int mid = length % 2 == 0 ? length / 2 : length / 2 + 1;
        int first = 0;
        int second = mid;

        while (first < mid && second < length) {
            if (temp[first] < temp[second]) {
                arr[left++] = temp[first++];
            } else {
                arr[left++] = temp[second++];
            }
        }
        while (first < mid) arr[left++] = temp[first++];

        while (second < length) arr[left++] = temp[second++];
    }
}
