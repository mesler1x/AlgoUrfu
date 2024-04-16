package _6LR._4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\mesle\\Desktop\\DEV\\AlgoUrfu\\src\\_6LR\\_4\\input.txt"));
        String[] line = bufferedReader.readLine().split(" ");
        int M = Integer.parseInt(line[0]);
        int N = Integer.parseInt(line[1]);
        int K = findK(M, N);
        System.out.println(K);
    }

    private static int findK(int m, int n) {
        int k = 2;
        //пока не вышли за пределы
        while (k <= 2 * 1000000) {
            int count = 0;
            for (int i = k; i < k + n && k + n <= 2 * 1000000; i++) {
                if (isPrime(i)) {
                    count++;
                }
            }

            if (count == m) return k;
            k++;
        }

        return -1;
    }

    public static boolean isPrime(int num) {
        boolean prime = num > 1 && (num % 2 != 0 || num == 2) && (num % 3 != 0 || num == 3);
        int i = 5;
        int d = 2;

        while (prime && i * i <= num) {
            prime = num % i != 0;
            i += d;
            d = 6 - d; // чередование прироста 2 и 4: 5 + 2, 7 + 4, 11 + 2, и т.д.
        }
        return prime;
    }
}
