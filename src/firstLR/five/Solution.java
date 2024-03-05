package firstLR.five;


import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int comment1Count = 0;
        int comment2Count = 0;
        int comment3Count = 0; // счетчик для скобок
        int literalStringsCount = 0;
        Stack<String> stack = new Stack<>();
        String input = "";
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '(' && i + 1 < line.length() && line.charAt(i + 1) == '*') {
                        input += "(*";
                        i++;
                    } else if (line.charAt(i) == '*' && i + 1 < line.length() &&
                            line.charAt(i + 1) == ')') {
                        input += "*)";
                        i++;
                    } else if (line.charAt(i) == '{') {
                        input += "{";
                    } else if (line.charAt(i) == '}') {
                        input += "}";
                    } else if (line.charAt(i) == '/' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                        input += "//";

                    } else if (line.charAt(i) == '‘') {
                        input += "‘";
                    } else if (i + 1 == line.length()) {
                        input += " ";
                    }
                }
            }
        }

        boolean inComment1 = false;
        boolean inComment2 = false;
        boolean inComment3 = false;
        boolean ignoreNextChar = false;

        for (int i = 0; i < input.length() - 1; i++) {
            char currentChar = input.charAt(i);
            char nextChar = input.charAt(i + 1);

            if (ignoreNextChar) {
                ignoreNextChar = false;
                continue;
            }

            if (!inComment1 && currentChar == '(' && nextChar == '*') {
                inComment1 = true;
                ignoreNextChar = true;
            } else if (inComment1 && currentChar == '*' && nextChar == ')' && !ignoreNextChar) {
                inComment1 = false;
                ignoreNextChar = true;
                comment1Count++;
            }

            if (!inComment2 && currentChar == '{') {
                inComment2 = true;
            } else if (inComment2 && currentChar == '}' && !ignoreNextChar) {
                inComment2 = false;
                comment2Count++;
            }

            if (!inComment3 && currentChar == '‘') {
                inComment3 = true;
            } else if (inComment3 && nextChar == '‘' && !ignoreNextChar) {
                inComment3 = false;
                ignoreNextChar = true;
                comment3Count++;
            }
        }
        System.out.println(input);
        System.out.println(comment1Count + " " + comment2Count + " " + comment3Count);
    }


}