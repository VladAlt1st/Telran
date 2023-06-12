package StringTasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// TODO: Напишите программу, которая принимает на вход две строки и проверяет,
//  являются ли они анаграммами (т.е. содержат ли они одинаковые символы в разном порядке).
public class Task_2 {
    public static void main(String[] args) {
        String a1 = "meteor";
        String a2 = "remote";
        String b1 = "debit card";
        String b2 = "bad credit";
        String c1 = "conversation";
        String c2 = "voice rants on";

        System.out.println(isAnagram(c1, c2));
        System.out.println(isAnagramImp(c1, c2));
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null) return false;

        char[] chars1 =  s1.replaceAll(" ", "").toCharArray();
        char[] chars2 =  s2.replaceAll(" ", "").toCharArray();

        if (chars1.length != chars2.length) return false;

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.compare(chars1, chars2) == 0;
    }

    private static boolean isAnagramImp(String s1, String s2) {
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
