package firstLR.eight;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nm = scanner.nextLine().split(" ");
        System.out.println(placeTrees(Integer.parseInt(nm[0]), Integer.parseInt(nm[1])));
    }

    public static int placeTrees(int n, int m) {
        switch (m) {
            case 0:
                return 1;
            case 1:
                return n;
        }
        if (m > n) {
            return 0;
        }
        int variants = 0;
        int interval = 0;
        while (true) {
            int lengthOfSubTrees = m + interval * (m - 1); // длина расстановки с пробелами равными
            //m - 1 потому что по краям мы не ставим интервал
            if (lengthOfSubTrees > n) { // если длина с интервалами больше чем длина грядки то выходим
                break;
            }
            variants += (n - lengthOfSubTrees) + 1; // смотрим сколько раз мы можем передвинуть засаженые деревья не выходя за грядку
            interval++;// увеличиваем интервал между деревом
        }
        return variants;
    }
}
