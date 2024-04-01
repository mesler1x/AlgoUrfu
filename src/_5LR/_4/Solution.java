package _5LR._4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/mesler/Рабочий стол/AlgoUrfu/src/_5LR/_4/input.txt"));
        int n = Integer.parseInt(bufferedReader.readLine());
        BigInteger[] array = new BigInteger[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = new BigInteger(bufferedReader.readLine());
        }

        for (int i = 0; i < array.length; i++) {
            if (isSqrt(array[i])) {
                System.out.println(i + 1);
            }
        }
    }

    public static boolean isSqrt(BigInteger n) {
        BigInteger low = BigInteger.ZERO;
        BigInteger high = n.add(BigInteger.ONE);
        while (low.compareTo(high.subtract(BigInteger.ONE)) < 0) { // пока low < high - 1
            BigInteger mid = low.add(high).divide(BigInteger.valueOf(2)); // (low + high) / 2
            if (n.compareTo(mid.multiply(mid)) < 0) { // if (mid * mid > n)
                high = mid;
            } else if (n.compareTo(mid.multiply(mid)) == 0) {
                return true; // если нашли число выходим
            } else {
                low = mid; // if (mid * mid) < n
            }
        }

        if (low.multiply(low).equals(n)) {
            return true;
        }
        return false;
    }
}
