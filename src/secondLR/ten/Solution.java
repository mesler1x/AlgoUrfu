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
        List<Integer> t = new ArrayList<>();
        long ans = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            t.add(arr[i]);
        }
        while (t.size() >= 4) {
            int _4 = t.get(t.size() - 1);
            int _3 = t.get(t.size() - 2);
            int _2 = t.get(1);
            int _1 = t.get(0);

            if (_4 + _1 + _3 + _1 < _2 + _1 + _4 + _2) {// сравниваем кто по максимальным выиграет
                // такое сравнение потому что они обра вернутся за последним
                ans += _4 + _1 + _3 + _1;// берем 2х максимальных и переводим их по одному
                t.remove(t.size() - 1);// убираем только 2х максимальных потому что первый возвратился
                t.remove(t.size() - 1);
            } else {
                ans += _2 + _1 + _4 + _2;// отпарвляем 2х максимальных вдвоем
                t.remove(t.size() - 1);// так же убираем 2х максимальных которые ушли
                t.remove(t.size() - 1);// 2 в итоге вернулся что бы забрать 1
            }
        }
        if (t.size() == 3) {
            ans += t.get(0) + t.get(1) + t.get(2);
        } else if (t.size() == 2) {
            ans += t.get(1);
        } else if (t.size() == 1) {
            ans += t.get(0);
        }
        return ans;
    }
}
