package _3LR._16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntToDoubleFunction;

public class Solution{

    public static double mergeCapitals(int n, int[] capitals) {
        Arrays.sort(capitals);
        double totalCost = 0;
        int newLen = 0;// новая длина которую назначим
        int numberOfCompress = capitals.length / 2; //
        for (int j = 0; j < numberOfCompress; j++) {
            for (int i = 0; i < capitals.length;  i++) {
                if (i == capitals.length - i - 1) {
                    //
                    newLen = i;// запоминаем индекс для обрезки массива
                    break;
                }

                capitals[i] = capitals[i] + capitals[capitals.length - 1 - i]; // ставим сжатое в начало
                totalCost += (double) (capitals[i] + capitals[capitals.length - 1 - i]) / 100; // считаем комиссию брокера
            }

            capitals = Arrays.copyOf(capitals, newLen + 1);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] capitals = new int[n];
        for (int i = 0; i < n; i++) {
            capitals[i] = scanner.nextInt();
        }

        double result = mergeCapitals(n, capitals);
        System.out.printf("%.2f", result);

        scanner.close();
    }
}
