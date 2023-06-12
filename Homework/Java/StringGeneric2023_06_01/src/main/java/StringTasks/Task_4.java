package StringTasks;

import java.util.*;

// TODO: Напишите программу, которая принимает на вход строку и выводит
//  все возможные комбинации символов этой строки в порядке возрастания их длины.
public class Task_4 {
    public static void main(String[] args) {
        String s = "ABCD";

        findPossibleCombinations(s);
    }

    private static void findPossibleCombinations(String s) {
        if (s == null || s.length() == 0) return;

        List<String> combinations = new ArrayList<>();

        findCombination(combinations, s, "", 0);

        combinations.sort(Comparator.comparing(String::length));
        System.out.println(combinations);
    }

    private static void findCombination(List<String> combinations, String s, String curr, int currLength) {
        if (currLength == s.length()) return;

        StringBuilder sb = new StringBuilder(curr);

        for (int i = currLength; i < s.length(); i++) {
            sb.append(s.charAt(i));
            combinations.add(sb.toString());
            findCombination(combinations, s, sb.toString(), i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
