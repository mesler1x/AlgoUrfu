package _6LR._7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\mesle\\Desktop\\DEV\\AlgoUrfu\\src\\_6LR\\_7\\input.txt"));
        String[] line1 = bufferedReader.readLine().split(" ");
        String[] line2 = bufferedReader.readLine().split(" ");
        int l = Integer.parseInt(line1[0]);
        int n = Integer.parseInt(line1[1]);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(line2[i]);
        }

        Arrays.sort(nums);
        int answer = compressCount(nums , l);
        System.out.println(answer);
    }

    public static int compressCount(int[] nums, int L) {
        // если минимальноe и максимальное числа можно сжать, считаем их как одно число
        if (nums[nums.length - 1] - nums[0] <= L) {
            return 1;
        }
        int i = 1;
        // двигаем указатель пока L позволяет нам сжать 2 числа
        while (nums[i] - nums[0] <= L) {
            i++;
        }
        // заходим в сжатый подмассив прибавляя то, что схлопнули
        return 1 + compressCount(Arrays.copyOfRange(nums, i, nums.length), L);
    }
}
