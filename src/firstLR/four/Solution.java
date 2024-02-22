package firstLR.four;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splitFirst = scanner.nextLine().split(" ");
        int maxPower = Integer.parseInt(splitFirst[0]);
        int m = Integer.parseInt(splitFirst[1]);
        int mod = Integer.parseInt(splitFirst[2]);

        long[] coefficients = new long[maxPower + 1];
        for (int i = 0; i < maxPower + 1; i++) {
            coefficients[i] = scanner.nextInt();
        }

        int[] arguments = new int[m];
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            arguments[i] = x;
        }

        for (int i = 0; i < m; i++) {
            //long x = scanner.nextLong();
            int res = calculate(coefficients, arguments[i], mod, maxPower);
            System.out.println(res);
        }
    }

    private static int calculate(long[] coefficients, long x, int mod, int maxPower) {
        long result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += (long) ((coefficients[i] * Math.pow(x, maxPower)));
            maxPower--;
        }
        return (int) (result % mod); // вычисление MOD тоесть 4 mod 10 = 4
    }
}
