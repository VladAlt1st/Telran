import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Map<Boolean[][], Character[][]> map1 = new HashMap<>();
        map1.put(new Boolean[][]{
                {true, true},
                {false, false}
        }, new Character[2][2]);
        map1.put(new Boolean[][]{
                {true, false},
                {false, true}
        }, new Character[2][2]);

        Map<Integer[][], String[][]> map2 = new HashMap<>();
        map2.put(new Integer[][]{
                {1, 2},
                {1, 3}
        }, new String[2][2]);
        map2.put(new Integer[][]{
                {1, 2},
                {1, 3}
        }, new String[2][2]);

        System.out.println(transformMaps(map1, map2));
    }

    /**
     * Создать новую Map<Character, String>,
     * где ключом будет символ из Character[][],
     * а значением будет соответствующая строка из String[][].
     * Необходимо выполнить следующие шаги:
     * Перебрать элементы первой мапы (Map<Boolean[][], Character[][]>).
     * Для каждого элемента преобразовать Boolean[][] в Character[][], заменив значения true на символ 'T' и false на символ 'F'.
     * Перебрать элементы второй мапы (Map<Integer[][], String[][]>).
     * Для каждого элемента преобразовать Integer[][] в String[][], преобразовав каждое число в строку.
     * Объединить соответствующие элементы из шагов 2 и 4 в новой мапе (Map<Character, String>).
     */
    private static Map<Character, String> transformMaps(Map<Boolean[][], Character[][]> map1, Map<Integer[][], String[][]> map2) {
        Map<Character, String> map = new HashMap<>();
        Iterator<Map.Entry<Boolean[][], Character[][]>> iterator1 = map1.entrySet().iterator();
        Iterator<Map.Entry<Integer[][], String[][]>> iterator2 = map2.entrySet().iterator();

        while (iterator1.hasNext() && iterator2.hasNext()) {
            List<Character> characters = transformToCharacter(iterator1.next().getKey());
            List<String> strings = transformToString(iterator2.next().getKey());

            for (int i = 0; i < characters.size(); i++) {
                map.merge(characters.get(i), strings.get(i), (s1, s2) -> s1 + " " + s2);
            }
        }
        return map;
    }

    private static List<Character> transformToCharacter(Boolean[][] booleans) {
        return Arrays.stream(booleans).flatMap(Arrays::stream).map(b -> b ? 'T' : 'F').toList();
    }

    private static List<String> transformToString(Integer[][] integers) {
        return Arrays.stream(integers).flatMap(Arrays::stream).map(Object::toString).toList();
    }
}
