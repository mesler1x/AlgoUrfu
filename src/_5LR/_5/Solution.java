package _5LR._5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\mesle\\Desktop\\DEV\\AlgoUrfu\\src\\_5LR\\_5\\input.txt"));
        String[] lines = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(lines[0]);
        double r = Double.parseDouble(lines[1]);
        String[] coordinates = new String[n];
        for (int i = 0; i < n; i++) {
            coordinates[i] = bufferedReader.readLine();
        }
        double[][] clients = new double[coordinates.length][2];
        for (int i = 0; i < coordinates.length; i++) {
            String client = coordinates[i];
            double[] clientCoordinates = new double[2];
            double x = Double.parseDouble(client.split(" ")[0]);
            double y = Double.parseDouble(client.split(" ")[1]);
            clientCoordinates[0] = x;
            clientCoordinates[1] = y;
            clients[i] = clientCoordinates;
        }
        find(clients, r);
    }

    private static void find(double[][] clients, double r) {
        Map<double[], Integer> map = new HashMap<>();
        for(double[] client : clients) {
            for (int i = 0; i < clients.length; i++) {
                if (client != clients[i])  {// если клиент не равен самому себе то смотрим на расстояние до другого клиента
                    double x1 = client[0];
                    double x2 = clients[i][0];
                    double y1 = client[1];
                    double y2 = clients[i][1];
                    double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
                    if (distance <= r) {
                        map.put(client, map.getOrDefault(client, 0) + 1);
                    }
                }
            }
        }

        Map<Integer, Integer> answr= new HashMap<>();
        for (int i = 0; i < clients.length; i++) {
            double[] client = clients[i];
            int count = map.getOrDefault(client, 0);
            answr.put(i, count);
        }

        //извлекаем что нашли для дальнейшей сортировки
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(answr.entrySet());

        // Сортировка
        list.sort(Map.Entry.<Integer, Integer>comparingByValue()
                .reversed()
                .thenComparing(Map.Entry.comparingByKey()));
        // Создание новой LinkedHashMap для упорядоченной map
        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        for(Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            StringBuilder builder = new StringBuilder();
            builder.append(entry.getKey()).append(" ").append(entry.getValue());
            System.out.println(builder);
        }
    }
}
