package firstLR.five;


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int type1Count = 0;
        int type2Count = 0;
        int type3Count = 0;
        int literalStringsCount = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    break; // Прерываем цикл при вводе пустой строки
                }
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '(' && i + 1 < line.length() && line.charAt(i + 1) == '*') {
                        type1Count++;
                        i++;
                    } else if (line.charAt(i) == '{') {
                        type2Count++;
                    } else if (line.startsWith("//")) {
                        type3Count++;
                        break;
                    } else if (line.charAt(i) == '\'') {
                        literalStringsCount++;
                        i = line.indexOf('\'', i + 1);
                    }
                }
            }
        }

        System.out.println(type1Count + " " + type2Count + " " + type3Count + " " + literalStringsCount);
    }
}
