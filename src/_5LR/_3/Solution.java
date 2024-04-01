package _5LR._3;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/mesler/Рабочий стол/AlgoUrfu/src/_5LR/_3/input.txt"));
        String word = bufferedReader.readLine();
        String pattern = bufferedReader.readLine();
        String answer = match(word, pattern);
        System.out.println(answer);
    }

    public static String match(String fileName, String pattern) {
        int i = 0;
        int j = 0;
        int starIndex = -1;
        int iIndex = -1;

        while (i < fileName.length()) {
            if (j < pattern.length() && (pattern.charAt(j) == '?' || fileName.charAt(i) == pattern.charAt(j))) {
                // если символы совпадают либо паттерн содержит любой символ (?)
                i++;
                j++;
            } else if (j < pattern.length() && pattern.charAt(j) == '*') {
                //если встречаем * запоминаем индекс
                starIndex = j;// позиция ПОСЛЕДНЕЙ звезды
                iIndex = i;// позиция имени файла c которого встретилась звезда
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;// перекидываем за звезду
                // индекс j все равно не двинется на 1 больше чем последняя звезда
                i = iIndex + 1;//перекидываем символ в файле
                iIndex++;
            } else { // если символы не совпадают и нет * и нет ?
                return "NO";
            }
        }

        //если есть оставшиеся звезды
        while (j < pattern.length() && pattern.charAt(j) == '*') {
            j++;
        }

        return j == pattern.length() ? "YES" : "NO";
    }
}

