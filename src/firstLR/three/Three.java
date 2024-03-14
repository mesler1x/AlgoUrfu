package firstLR.three;

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
        MyBigInteger number1 = new MyBigInteger(firsNum);
        MyBigInteger number2 = new MyBigInteger(secondNum);
        String result = null;
        if (operation.equals("+")){
            result = MyBigInteger.add(number1, number2).toString();
        } else if (operation.equals("-")){
            result = MyBigInteger.subtract(number1, number2).toString();
        }
        return result != null ? result.toString() : null;
    }
}
