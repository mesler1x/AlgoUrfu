package _5LR._2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // ключ это имя - значение это номер телефонв
        Map<String, String> map = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/mesler/Рабочий стол/AlgoUrfu/src/_5LR/_2/input.txt"));
        bufferedReader.readLine();
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            if (line.startsWith("ADD")) {
                String keyAndValue = line.substring(4);
                String key = keyAndValue.split(" ")[0];
                String value = keyAndValue.split(" ")[1];
                if (map.containsKey(key)) {
                    System.out.println("ERROR");
                } else {
                    map.put(key, value);
                }
            } else if (line.startsWith("UPDATE")) {
                String keyAndValue = line.substring(7);
                String key = keyAndValue.split(" ")[0];
                String value = keyAndValue.split(" ")[1];
                if (map.containsKey(key)) {
                    map.put(key, value);
                } else {
                    System.out.println("ERROR");
                }
            } else if (line.startsWith("DELETE")) {
                String key = line.substring(7);
                if (map.containsKey(key)) {
                    map.remove(key);
                } else {
                    System.out.println("ERROR");
                }
            } else if (line.startsWith("PRINT")) {
                String key = line.substring(6);
                if (map.containsKey(key.trim())) {
                    StringBuilder result = new StringBuilder();
                    result.append(key).append(" ").append(map.get(key));
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
