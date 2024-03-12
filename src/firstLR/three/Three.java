package firstLR.three;

import java.math.BigInteger;
import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firsNum = scanner.nextLine();
        String operation = scanner.nextLine();
        String secondNum = scanner.nextLine();
        System.out.println(permutationNumbers(firsNum, secondNum, operation));
    }

    public static String permutationNumbers(String firsNum, String secondNum, String operation){
        try {
            BigInteger num1 = new BigInteger(firsNum);
            BigInteger num2 = new BigInteger(secondNum);
            BigInteger result = null;

            if (operation.equals("+")){
                result = (num1.add(num2));
            } else if (operation.equals("-")){
                result = (num1.subtract(num2));
            }
            return result != null ? result.toString() : null;
        } catch (Exception e){
            throw new NullPointerException("num can not be null");
        }
    }
}
