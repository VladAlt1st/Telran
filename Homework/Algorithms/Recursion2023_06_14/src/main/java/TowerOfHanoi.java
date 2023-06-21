import java.util.Stack;

public class TowerOfHanoi {
    /*Ханойская башня
    Задача заключается в следующем:
    Имеется три стержня — левый, средний и правый.
    На левом стержне находятся n дисков, диаметры которых различны.
    Диски упорядочены по размеру диаметра, сверху лежит наименьший, снизу — наибольший.
    Требуется перенести диски с левого стержня на правый, используя средний стержень как вспомогательный.

    Головоломка имеет следующие два правила:
    Вы не можете поместить больший диск на меньший диск.
    За один раз можно перемещать только один диск.
    Реализуйте два подхода для решения.
    Итеративно
    Рекурсивно*/
    public static void main(String[] args) {
        Stack<Integer> src = new Stack<>();
        Stack<Integer> help = new Stack<>();
        Stack<Integer> dest = new Stack<>();

        src.push(1);
        src.push(2);
        src.push(3);

        System.out.print(src);
        System.out.print(help);
        System.out.println(dest);

        hanoiTowerRec(src, help, dest, src.size());

        System.out.print(src);
        System.out.print(help);
        System.out.println(dest);
    }

    // Рекурсивно
    private static void hanoiTowerRec(Stack<Integer> src, Stack<Integer> help, Stack<Integer> dest, int n) {
        if (n == 0) return;
        hanoiTowerRec(src, dest, help, n - 1);
        dest.push(src.pop());
        hanoiTowerRec(help, src, dest, n - 1);
    }

    // Итеративно --
}
