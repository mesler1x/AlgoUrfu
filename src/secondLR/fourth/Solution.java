package secondLR.fourth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(lines[0]);
        int firstNum = Integer.parseInt(lines[1]);
        int multiplyNum = Integer.parseInt(lines[2]);
        int mod = Integer.parseInt(lines[3]);
        int sum = findSum(n, firstNum, multiplyNum, mod);
        System.out.println(sum);
    }

    private static int findSum(int n, int firstNum, int multiplyNum, int mod) {
        int ans = 0;
        int[] arr = new int[n];
        arr[0] = firstNum;
        Set<Integer> sortedElements = new TreeSet<>();
        sortedElements.add(firstNum);
        for (int i = 1; i < n; i++) {
            arr[i] = (int) ((arr[i - 1] * multiplyNum) % (Math.pow(2, 32) - 1) % mod);
            sortedElements.add(arr[i]);
        }

        int i = 1;
        for(Integer num : sortedElements){
            if (i % 2 != 0){
                ans += num;
            }
            i++;
        }

        return ans % mod;
    }
}
