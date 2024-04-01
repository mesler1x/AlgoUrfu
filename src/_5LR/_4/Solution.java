package _5LR._4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/mesler/Рабочий стол/AlgoUrfu/src/_5LR/_4/input.txt"));
        int n = Integer.parseInt(bufferedReader.readLine());
        long[] array = new long[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 0; i < array.length; i++) {
            if (isFullSquared(array[i])) {
                System.out.println(i + 1);
            }
        }
    }

    private static boolean isFullSquared(long number) {
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 2; i <= number ; i++) {
            while (number % i == 0) {
                number = number / i;
                map.put(number, map.getOrDefault(number, 0) + 1);
            }
        }

        for(Map.Entry<Long, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
