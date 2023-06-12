package StringTasks;

import java.util.ArrayList;
import java.util.List;

// TODO: Напишите программу, которая принимает на вход строку и выводит все перестановки символов этой строки.
public class Task_1 {
    public static void main(String[] args) {
        String s = "ABC";

        findAllCombinations(s);

        findAllCombinationsRec(s);
    }

    private static void findAllCombinations(String s) {
        if (s == null || s.length() == 0) return;

        List<String> combinations = new ArrayList<>();
        combinations.add(String.valueOf(s.charAt(0)));

        for (int i = 1; i < s.length(); i++) {
            for (int j = combinations.size() - 1; j >= 0; j--) {
                String tmp = combinations.remove(j);

                for (int k = 0; k <= tmp.length(); k++) {
                    combinations.add(tmp.substring(0, k) + s.charAt(i) + tmp.substring(k));
                }
            }
        }
        System.out.println(combinations);
    }

    private static void findAllCombinationsRec(String s){
        if (s == null || s.length() == 0) return;

        findCombination(s.toCharArray(), 0);
    }

    private static void findCombination(char[] chars, int index) {
        if (index == chars.length - 1) {
            System.out.println(String.valueOf(chars));
        } else {
            for (int i = index; i < chars.length; i++) {
                swap(chars, index, i);
                findCombination(chars, index + 1);
                swap(chars, index, i);
            }
        }
    }

    private static void swap(char[] chars, int first, int second) {
        char tmp = chars[first];
        chars[first] = chars[second];
        chars[second] = tmp;
    }
}
