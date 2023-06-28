import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] arr = {9, 9, 9};
        System.out.println(Arrays.toString(incrementArray(arr)));
    }

    /**
     * Дано число, которое задано своими разрядами, расположенными в массиве. Прибавить к этому числу 1.
     * Example 1:
     * Input: digits = [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123. Incrementing by one gives 123 + 1 = 124.
     * Thus, the result should be [1,2,4].
     *
     * Example 2:
     * Input: digits = [4,3,2,1]
     * Output: [4,3,2,2]
     * Explanation: The array represents the integer 4321. Incrementing by one gives 4321 + 1 = 4322.
     * Thus, the result should be [4,3,2,2].
     *
     * Example 3:
     * Input: digits = [9]
     * Output: [1,0]
     * Explanation: The array represents the integer 9. Incrementing by one gives 9 + 1 = 10.
     * Thus, the result should be [1,0].
     */

    public static int[] incrementArray(int[] arr) {
        if (arr == null) throw new NullPointerException();
        return decompose(compose(arr) + 1);
    }

    private static int compose(int[] arr) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num += Math.abs(arr[i]);

            if (i != arr.length - 1) {
                num *= 10;
            }
        }
        return num;
    }

    private static int[] decompose(int num) {
        int[] arr = new int[String.valueOf(num).length()];

        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - 1 - i] = num % 10;
            num /= 10;
        }
        return arr;
    }
}
