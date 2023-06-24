public class Task1 {
    public static void main(String[] args) {
        int[] first = {100, 112, 256, 349, 770};
        int[] second = {72, 86, 113, 119, 265, 445, 892};
        int k = 7;

        System.out.println(getByPosition(first, second, k));
    }

    /**
     *  Имея два отсортированных массива размера m и n соответственно, вам нужно найти элемент,
     *  который будет находиться на k-й позиции в конечном отсортированном массиве.
     */
    private static int getByPosition(int[] first, int[] second, int k) {
        if (k < 0 || k > first.length + second.length) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for length %d", k - 1, first.length + second.length));
        }

        int firstPoint = 0;
        int secondPoint = 0;

        while (firstPoint < first.length && secondPoint < second.length) {
            if (first[firstPoint] < second[secondPoint]) {
                if (firstPoint + secondPoint == k - 1) return first[firstPoint];
                firstPoint++;
            } else {
                if (firstPoint + secondPoint == k - 1) return second[secondPoint];
                secondPoint++;
            }
        }

        if (firstPoint < first.length) {
            return first[k - secondPoint - 1];
        } else {
            return second[k - firstPoint - 1];
        }
    }
}
