package StringTasks;

import java.util.ArrayList;
import java.util.List;

// TODO: Напишите программу, которая принимает на вход строку и выводит все подстроки этой строки.
public class Task_3 {
    public static void main(String[] args) {
        String s = "ABC";

        findSubstrings(s);
    }

    private static void findSubstrings(String s) {
        if (s == null || s.length() == 0) return;

        List<String> substrings = new ArrayList<>();

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                substrings.add(s.substring(j - i, j));
            }
        }
        System.out.println(substrings);
    }
}
