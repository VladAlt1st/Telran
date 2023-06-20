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
        Stack<Integer> left = new Stack<>();
        Stack<Integer> mid = new Stack<>();
        Stack<Integer> right = new Stack<>();

        left.push(1);
        left.push(2);
        left.push(3);

        System.out.print(left);
        System.out.print(mid);
        System.out.println(right);

        hanoiTowerRec(left, mid, right, left.size());

        System.out.print(left);
        System.out.print(mid);
        System.out.println(right);
    }

    // Рекурсивно
    private static void hanoiTowerRec(Stack<Integer> left, Stack<Integer> mid, Stack<Integer> right, int count) {
        if (count > 0){
            hanoiTowerRec(left, right, mid,count-1);
            right.push(left.pop());
            hanoiTowerRec(mid, left, right,count-1);
        }
    }

    // Итеративно --
}
