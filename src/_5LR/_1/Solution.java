package _5LR._1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // подстроки
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\mesle\\Desktop\\DEV\\AlgoUrfu\\src\\_5LR\\_1\\input.txt"));
        String line = bufferedReader.readLine();
        System.out.println(findMaxWeightOfSubStrings(line));
    }
    private static int findMaxWeightOfSubStrings(String line) {
        Map<String, Integer> weights = new HashMap<>();
        int maxWeight = Integer.MIN_VALUE;

        for (int window = 1; window <= line.length(); window++) {
            for (int i = 0; i <= line.length() - window; i++) {
                String substring = line.substring(i, i + window);
                weights.put(substring, weights.getOrDefault(substring, 0) + 1);
            }// ищем подпоследовательности
        }

        for (Map.Entry<String, Integer> entry : weights.entrySet()) {
            String substring = entry.getKey();
            int occurrences = entry.getValue();
            int weight = substring.length() * occurrences;

            if (weight > maxWeight) {
                maxWeight = weight;
            }
        }

        return maxWeight;
    }
}
