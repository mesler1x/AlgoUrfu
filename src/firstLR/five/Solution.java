package firstLR.five;


import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int type1Count = 0;
        int type2Count = 0;
        int type3Count = 0;
        int literalStringsCount = 0;
        Stack<String> stack = new Stack<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '(' && i + 1 < line.length() && line.charAt(i + 1) == '*') {
                        stack.add("(*");
                        i++;
                    } else if (line.charAt(i) == '*' && i + 1 < line.length() &&
                            line.charAt(i + 1) == ')' &&
                            !stack.isEmpty() &&
                            stack.peek().equals("(*")) {
                        type1Count++;
                        stack.pop();
                        i++;
                    }
                }
                stack.clear();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '{') {
                        stack.add("{");
                    } else if (line.charAt(i) == '}' && !stack.isEmpty() && stack.peek().equals("{")) {
                        type2Count++;
                        stack.pop();
                    }
                }
                stack.clear();
                if (line.contains("//") && !line.endsWith(";")) {
                    type3Count++;
                }

                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '‘') {
                        literalStringsCount++;
                    }
                }
                if (literalStringsCount % 2 != 0){
                    literalStringsCount --;
                }
            }
        }

        System.out.println(type1Count + " " + type2Count + " " + type3Count + " " + literalStringsCount);
    }
}
