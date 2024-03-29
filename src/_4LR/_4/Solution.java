package _4LR._4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/mesler/Рабочий стол/AlgoUrfu/src/_4LR/_4/input.txt"));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = bufferedReader.readLine();
        }

        System.out.println(getCountAnagrams(words));
    }

    private static int getCountAnagrams(String[] words) {
        Map<Map<Character, Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Map<Character, Integer> currWord = new HashMap<>();
            for (int j = 0; j < word.length(); j++) {
                currWord.put(word.charAt(j), currWord.getOrDefault(word.charAt(j), 0) + 1);
            }
            // если такое количество букв есть, то у нас есть группа
            map.put(currWord, map.getOrDefault(currWord, 0) + 1);
        }

        int res = 0;
        for(Map.Entry<Map<Character, Integer>, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) { // если анаграммы 2 и больше инкрументим группу
                res++;
            }
        }
        return res;
    }
}
