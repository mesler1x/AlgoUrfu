package firstLR.three;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        System.out.println(longPlusOrMinus());
    }

    public static BigInteger longPlusOrMinus(){
        Scanner scanner = new Scanner(System.in);
        String firsNum = scanner.nextLine();
        String operation = scanner.nextLine();
        String secondNum = scanner.nextLine();

        BigInteger num1 = new BigInteger(firsNum);
        BigInteger num2 = new BigInteger(secondNum);
        BigInteger result = null;

        if (operation.equals("+")){
            result = (num1.add(num2));
        } else if (operation.equals("-")){
            result = (num1.subtract(num2));
        }

        return result;
    }
}
