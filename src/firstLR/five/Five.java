package firstLR.five;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Five {
    public static void main(String[] args) {
        int type1Count = 0;
        int type2Count = 0;
        int type3Count = 0;
        int literalStringsCount = 0;
        List<String> lines = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        StringBuilder types = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            lines.add(line);
        }

        for(String line : lines){
            // парсинг в одну строку
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '(' && i + 1 < line.length() && line.charAt(i + 1) == '*') {
                    types.append("(*");
                    i++;
                } else if (line.charAt(i) == '*' && i + 1 < line.length() &&
                        line.charAt(i + 1) == ')') {
                    types.append("*)");
                    i++;
                } else if (line.charAt(i) == '{') {
                    types.append("{");
                } else if (line.charAt(i) == '}') {
                    types.append("}");
                } else if (line.charAt(i) == '/' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                    types.append("//");

                } else if (line.charAt(i) == '‘') {
                    types.append("‘");
                } else if (i + 1 == line.length()) { // переносы строки заменяем пробелом
                    types.append(" ");
                }
            }
        }



        for (int i = 0; i < types.length(); i++) {
            if (types.charAt(i) == '(' && i + 1 < types.length() && types.charAt(i + 1) == '*' && !stack.contains("(*")) {
                if ((!types.substring(0, i).contains("‘") && types.substring(i + 1).contains("‘")) ||
                        (!types.substring(0, i).contains("{") && types.substring(i + 1).contains("}")) ||
                        (!types.substring(0, i).contains("//") && i - 1 > 0 && types.charAt(i - 1) != ' ')) {
                    stack.add("(*");
                }
                i++;
            } else if (types.charAt(i) == '*' && i + 1 < types.length() && types.charAt(i + 1) == ')' && stack.contains("(*")) {
                stack.pop();
                type1Count++; // мы не зайдем в это условие если не добавим в стек до этого
                i++;
            }
        }
        stack.clear();

        for (int i = 0; i < types.length(); i++) {
            if (types.charAt(i) == '{' && !stack.contains("{")) {
                if ((!types.substring(0, i).contains("‘") && types.substring(i + 1).contains("‘")) ||
                        (!types.substring(0, i).contains("(*") && i + 1 < types.length() && types.substring(i + 1).contains("*)")) ||
                        (!types.substring(0, i).contains("//") && i - 1 > 0 && types.charAt(i - 1) != ' ')) {
                    stack.add("{");
                }
            } else if (types.charAt(i) == '}' && stack.contains("{")) {
                stack.pop();
                type2Count++;
            }
        }
        stack.clear();
        for (int i = 0; i < types.length(); i++) {
            if (types.charAt(i) == '‘' && !stack.contains("‘")) {
                stack.add("‘");
            } else if (types.charAt(i) == '‘' && stack.contains("‘")) {
                stack.pop();
                literalStringsCount++;
            }
        }
        stack.clear();
        String[] typesSplit = types.toString().split(" "); // сплитим для дальнейшей проверки что он в начале строки (после преобразования)
        for (int i = 0; i < types.length(); i++) {
            if (types.charAt(i) == '/' && i + 1 < types.length() && types.charAt(i + 1) == '/' && !stack.contains("//")) {
                if ((!types.substring(0, i).contains("‘") && types.substring(i + 1).contains("‘")) ||
                        (!types.substring(0, i).contains("{") && types.substring(i + 1).contains("}")) ||
                        (!types.substring(0, i).contains("(*") && i + 1 < types.length() && types.substring(i + 1).contains("*)"))) {
                    types.replace(i, i + 1, "");
                }
                i++;
            }
        }

        for(String s : typesSplit){
            if (s.startsWith("//")){
                type3Count++;
            }
        }
        stack.clear();
        System.out.println(types);
        System.out.println(type1Count + " " + type2Count + " " + type3Count + " " + literalStringsCount);
    }
}