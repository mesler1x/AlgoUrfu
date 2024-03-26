package _4LR._3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/mesler/Рабочий стол/AlgoUrfu/src/_4LR/_3/input.txt"));
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            if (line.startsWith("ADD")) {
                String nameAndNum = line.substring(4);
                StringBuilder name = new StringBuilder();
                int numDigit = 0;
                for (int i = 0; i < nameAndNum.length(); i++) {
                    if (Character.isDigit(nameAndNum.charAt(i))) {
                        numDigit = i;
                        break;
                    }
                    name.append(nameAndNum.charAt(i));
                }
                String number = nameAndNum.substring(numDigit);
                map.put(name.toString().trim(), number);
            } else if (line.startsWith("EDITPHONE")) {
                String nameAndNum = line.substring(10);
                StringBuilder name = new StringBuilder();
                int numDigit = 0;
                for (int i = 0; i < nameAndNum.length(); i++) {
                    if (Character.isDigit(nameAndNum.charAt(i))) {
                        numDigit = i;
                        break;
                    }
                    name.append(nameAndNum.charAt(i));
                }
                String number = nameAndNum.substring(numDigit);
                if (map.containsKey(name.toString().trim())) {
                    map.put(name.toString().trim(), number);
                } else {
                    System.out.println("ERROR");
                }
            } else if (line.startsWith("DELETE")) {
                String name = line.substring(7);
                if (map.containsKey(name)) {
                    map.remove(name);
                } else {
                    System.out.println("ERROR");
                }
            } else if (line.startsWith("PRINT")) {
                String name = line.substring(6);
                if (map.containsKey(name.trim())) {
                    StringBuilder result = new StringBuilder();
                    result.append(name).append(" ").append(map.get(name));
                    System.out.println(result);
                } else {
                    System.out.println("ERROR");
                }
            } else {
                System.out.println("ERROR");
            }
        }
    }
}
