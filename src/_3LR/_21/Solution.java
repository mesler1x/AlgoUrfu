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
                } else {
                    curVolumes++;//мы завершаем том и считаем его
                    lastVolume = chapters[i];
                    if (chapters[i] > mid) {
                        //присваиваем значение нужны что бы потом сдвинуть left
                        curVolumes = nVolumes;
                        break;
                    }
                }
            }

            curVolumes++;
            if (curVolumes <= nVolumes) {
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