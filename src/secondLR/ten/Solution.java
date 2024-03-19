package secondLR.ten;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        /*File file = new File("INPUT.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));*/
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[n];
        String[] strs = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }

        long ans = findRes(arr);
        System.out.println(ans);
    }

    private static long findRes(int[] arr) {
        List<Integer> people = new ArrayList<>();
        long ans = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            people.add(arr[i]);
        }
        while (people.size() >= 4) {
            int _4 = people.get(people.size() - 1);
            int _3 = people.get(people.size() - 2);
            int _2 = people.get(1);
            int _1 = people.get(0);

            if (_4 + _1 + _3 + _1 < _2 + _1 + _4 + _2) {// сравниваем кто по максимальным выиграет
                // такое сравнение потому что они обра вернутся за последним
                ans += _4 + _1 + _3 + _1;// берем 2х максимальных и переводим их по одному - это быстрее
                people.remove(people.size() - 1);// убираем только 2х максимальных потому что первый возвратился
                people.remove(people.size() - 1);
            } else {
                ans += _2 + _1 + _4 + _2;// отпарвляем 2х максимальных вдвоем
                people.remove(people.size() - 1);// так же убираем 2х максимальных которые ушли
                people.remove(people.size() - 1);// 2 в итоге вернулся что бы забрать 1
            }
        }
        // в итоге сводя задачку постоянно к n-2 приходям к данным кейсам, уже очевидным
        if (people.size() == 3) {
            ans += people.get(0) + people.get(1) + people.get(2);
        } else if (people.size() == 2) {
            ans += people.get(1);
        } else if (people.size() == 1) {
            ans += people.get(0);
        }
        return ans;
    }
}
