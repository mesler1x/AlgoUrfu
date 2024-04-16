package _6LR._9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\mesle\\Desktop\\DEV\\AlgoUrfu\\src\\_6LR\\_9\\input.txt"));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);


        // Массив, содержащий количество черных полосок для каждой цифры от 0 до 9
        findNumbers(k, n);
        br.close();
    }

    private static void findNumbers(int k, int n) {
        if (k < n * 2) {
            System.out.println("NO SOLUTION");
            return;
        }
        int[] blackSegments = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        int copyK = k;
        StringBuilder minNumber = new StringBuilder();
        for (int i = 0; i < n; i++) {
            //смотрим какую цифру мы можем поставить в разряд (начиная с минимальных)
            for (int j = 0; j <= 9; j++) {
                if (i == 0 && j == 0) {
                    continue; // Исключаем ведущий ноль
                }
                //смотрим сколько ещё мы можем поставить черных полосок после подстановки ДАННОЙ цифры
                int remainingBlackCount = copyK - blackSegments[j];
                if (remainingBlackCount >= 0 &&
                        remainingBlackCount <= (n - i - 1) * 7 &&
                // мы идём с минимальных чисел, но мы должны уложится в лимит по полоскам
                // мы возьмем это число если всё остальное сможем закрыть единицами (потому что они минимальны по количеству полосок)
                        (n - i - 1) * 2 <= remainingBlackCount) {
                    minNumber.append(j);
                    copyK -= blackSegments[j];
                    break;
                }
            }
        }

        if (copyK != 0) {
            System.out.println("NO SOLUTION");
        } else {
            System.out.println(minNumber);

            // Максимальное количество черных полосок
            StringBuilder maxNumber = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 9; j >= 0; j--) {
                    int remainingBlackCount = k - blackSegments[j];
                    if (remainingBlackCount >= 0 && remainingBlackCount <= (n - i - 1) * 7 && (n - i - 1) * 2 <= remainingBlackCount) {
                        maxNumber.append(j);
                        k -= blackSegments[j];
                        break;
                    }
                }
            }
            System.out.println(maxNumber);
        }
    }
}
