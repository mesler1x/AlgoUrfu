package firstLR.four;

import java.util.Scanner;

public class Four {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splitFirst = scanner.nextLine().split(" ");
        int maxPower = Integer.parseInt(splitFirst[0]); // число n
        int m = Integer.parseInt(splitFirst[1]); // количество аргументов
        int mod = Integer.parseInt(splitFirst[2]); // на что делим результат от каждого кефа

        int[] coefficients = new int[maxPower + 1];//а кефы
        for (int i = 0; i < maxPower + 1; i++) {
            coefficients[i] = scanner.nextInt();
        }

        int[] arguments = new int[m];// иксы для которых сосчитать полином
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            arguments[i] = x;
        }

        String res = resultOfPolinomWithArgs(coefficients, arguments, mod, maxPower);
        System.out.println(res);
    }

    public static String resultOfPolinomWithArgs(int[] coefficients, int[] arguments, int mod, int polinomPower) {// polinom power - n
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arguments.length; i++) {
            int res = calculateForOneArgument(coefficients, arguments[i], mod, polinomPower);
            sb.append(res).append(" ");
        }

        return sb.toString().trim();
    }


    private static int calculateForOneArgument(int[] coefficients, int x, int mod, int polinomPower) {
        long result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += (long) ((coefficients[i] * Math.pow(x, polinomPower)));
            polinomPower--;// уменьшение степени полинома
        }
        return (int) (result % mod); // вычисление MOD
    }
}
