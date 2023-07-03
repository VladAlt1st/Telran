package Tasks11_20;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task12 {

    // Дан список слов. Необходимо проверить, содержат ли они одинаковые символы(являются ли анаграммами)
    // и вывести результат.

    public static void main(String[] args) {
        List<String> list = List.of( "angel", "dusty", "arc", "car", "glean", "lange", "study");

        list.stream()
                .collect(Collectors.groupingBy(
                        s -> s,
                        Collectors.mapping(
                                s -> list.stream()
                                        .filter(str -> !str.equals(s))
                                        .collect(Collectors.partitioningBy(str -> isAnagram(str, s))),
                                Collectors.toList()
                        )
                ))
                .entrySet()
                .forEach(System.out::println);
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null) return false;

        Map<Character, Integer> map = new HashMap<>();
        int length = Math.max(s1.length(), s2.length());

        for (int i = 0; i < length; i++) {
            if (i < s1.length() && s1.charAt(i) != ' ') {
                map.merge(s1.charAt(i), 1, Integer::sum);
            }
            if (i < s2.length() && s2.charAt(i) != ' ') {
                map.merge(s2.charAt(i), -1, Integer::sum);
            }
        }
        return map.values().stream().allMatch(i -> i == 0);
    }
}
