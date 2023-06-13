
public class TimeComplexityTasks {

    // Практические задачи: какова временная сложность?

    // O(n)
    private static void task1(int n) {
        if (n == 1) return;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.println("*");
                break;
            }
        }
    }

    // O(n * log n)
    private static void task2(int n) {
        int i = 0;
        int j = 0;
        int a = 0;

        for (i = n / 2; i <= n; i++) {
            for (j = 2; j <= n; j *= 2) {
                a += n / 2;
            }
        }
    }

    // O(n2)
    private static void task3(int n) {
        int a = 0;

        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                a = a + i + j;
            }
        }
    }

    // O(log n)
    private static void task4(int n) {
        int a = 0;
        int i = n;

        while (i > 0) {
            a = a + i;
            i = i / 2;
        }
    }
}
