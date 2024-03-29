package _4LR._5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/mesler/Рабочий стол/AlgoUrfu/src/_4LR/_5/input.txt"));
        String[] lines = bufferedReader.readLine().split(" ");
        int cacheSize = Integer.parseInt(lines[0]);
        int requestsCount = Integer.parseInt(lines[1]);
        int[] requests = new int[requestsCount];
        for (int i = 0; i < requestsCount; i++) {
            requests[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.println(countRequestsToServer(cacheSize, requests));
    }

    private static int countRequestsToServer(int cacheSize, int[] requests) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : requests) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> cache = new HashSet<>();

        for(int num : requests) {
            if (!cache.contains(num) && cache.size() < cacheSize &&
            map.get(num) > 1) {// если число будет больше 1 раза добавим в кеш
                cache.add(num);
                count++; // первый раз обратимся к серверу
                map.put(num, map.get(num) - 1);
            } else if (cache.contains(num) && map.get(num) == 1) { //
                // если число больше не будет встречаться уберем его из кеша
                cache.remove(num);
                map.remove(num);
            } else if (cache.contains(num) && map.get(num) > 1) {
                // если пришло число которое есть в кеше и оно еще будет встречаться
                // просто убавим его количество
                // не будем обращаться к серверу
                map.put(num, map.get(num) - 1);
            } else if (!cache.contains(num) && map.get(num) > 1 && cache.size() == cacheSize) {
                // если приходит чисто которое будет встречаться много
                count++;
                int minNum = Integer.MAX_VALUE;
                int numToRemove = 0;

                for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (cache.contains(entry.getKey())) {
                        int value = entry.getValue();
                        if (value < minNum) {
                            minNum = value;
                            numToRemove = entry.getKey();
                        }
                    }
                }

                if (minNum > map.get(num)) {
                    // если это чисто будет встречаться меньше чем все которые щас в кеше
                    // будем просто обращаться к серверу
                    map.put(num, map.get(num) - 1);
                } else {
                    cache.remove(numToRemove);
                    cache.add(num);
                    map.put(num, map.get(num) - 1);
                }
            } else {
                // если число встретиться только 1 раз то просто обратимся к серверу
                count++;
            }
        }

        return count;
    }
}
