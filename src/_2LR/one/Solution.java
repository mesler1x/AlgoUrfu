package _2LR.one;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = findMax(arr);

        System.out.println(max);
    }

    private static int findMax(int[] arr) {
        int max1;
        int max2;
        Arrays.sort(arr);
        max1 = arr[0] * arr[1] * arr[arr.length - 1];
        max2 = arr[arr.length - 1] * arr[arr.length - 1] * arr[arr.length - 3];
        return Math.max(max2, max1);
    }
}
