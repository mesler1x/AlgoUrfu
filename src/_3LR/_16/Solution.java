package _3LR._16;

import Sorting.SortingIntArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader
                (new FileReader("C:\\Users\\mesle\\Desktop\\DEV\\AlgoUrfu\\src\\_3LR\\_16\\input.txt"));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] capitals = new int[n];

        for (int i = 0; i < capitals.length; i++) {
            capitals[i] = Integer.parseInt(bufferedReader.readLine());
        }


        double sum = 0;
        while (capitals.length > 1) {
            SortingIntArray.quickSort(capitals);
            sum += (double) (capitals[0] + capitals[1]) / 100;
            capitals[1] = capitals[0] + capitals[1];
            capitals = Arrays.copyOfRange(capitals, 1, capitals.length);
        }


        System.out.printf("%.2f", sum);
    }
}
