package _4LR._2;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader("/home/mesler/Рабочий стол/AlgoUrfu/src/_4LR/_2/input.txt"));
        String[] lines = scanner.nextLine().split(" ");
        int n = Integer.parseInt(lines[0]);
        int m = Integer.parseInt(lines[1]);
        int k = Integer.parseInt(lines[2]);

        List<int[]> etalon = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] arr = new int[m];
            String[] l = scanner.nextLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(l[j]);
            }
            etalon.add(arr);
        }

        List<int[]> prob = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String[] l = scanner.nextLine().split(" ");
            int[] arr = new int[m];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(l[j]);
            }
            prob.add(arr);
        }

        find(etalon, prob);
    }

    private static void find(List<int[]> etalon, List<int[]> prob) {
        Set<Set<Integer>> mainSet = new HashSet<>();
        for (int i = 0; i < etalon.size(); i++) {
            int[] arr = etalon.get(i);
            Set<Integer> etalonSet = new HashSet<>();
            for (int j = 0; j < arr.length; j++) {
                etalonSet.add(arr[j]);
            }
            mainSet.add(etalonSet);
        }

        for (int i = 0; i < prob.size(); i++) {
            int[] arr = prob.get(i);
            // собираю сет из пробного множества
            Set<Integer> probSet = new HashSet<>();
            for (int j = 0; j < arr.length; j++) {
                probSet.add(arr[j]);
            }
            if (mainSet.contains(probSet)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}

