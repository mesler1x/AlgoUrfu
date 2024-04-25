package _3LR._21;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\mesle\\Desktop\\DEV\\AlgoUrfu\\src\\_3LR\\_21\\input.txt"));
        int n = Integer.parseInt(reader.readLine());
        int[] chapters = new int[n];
        String[] lines = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            chapters[i] = Integer.parseInt(lines[i]);
        }
        int nVolumes = Integer.parseInt(reader.readLine());
        int left = Arrays.stream(chapters).min().getAsInt();
        int right = Arrays.stream(chapters).sum();
        while (left + 1 < right) {
            int mid = (left + right) / 2;//предволагаем сколько страниц поместится в том
            int curVolumes = 0;
            int lastVolume = 0;
            for (int i = 0; i < n; i++) {
                if (lastVolume + chapters[i] <= mid) {//пробуем класть элемент в текущий том
                    lastVolume += chapters[i];
                } else {//если больше не помещается то есть у нас толщина тома становится больше чем которую мы приняли за максимальную(mid)
                    curVolumes++;//мы завершаем том и считаем его
                    lastVolume = chapters[i];//все предыдущие мы уже положили идем с того который не смогли положить
                    if (chapters[i] > mid) {//если следующая глава уже больше чем предположительный том нам нет смысла смотреть дальше
                        //присваиваем значение нужны что бы потом сдвинуть left
                        curVolumes = nVolumes;
                        break;
                    }
                }
            }

            curVolumes++;//мы во всех случаях не заходим считать последний том но надо его посчитать
            if (curVolumes <= nVolumes) {//если количество томов которое у нас получилось меньше
                // target кол-во томов нам нужно уменьшить чтобы когда мы клали мы могли поместить в том меньшее кол во глав но создать больше томов
                //томов больше страниц меньше
                right = mid;
            } else if (curVolumes > nVolumes) {
                //томов меньше страниц больше
                left = mid;
            }
        }

        System.out.println(right);
    }
}