package _5LR._5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/mesler/Рабочий стол/AlgoUrfu/src/_5LR/_5/input.txt"));
        String[] lines = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(lines[0]);
        int r = Integer.parseInt(lines[1]);
        String[] coordinates = new String[n];
        for (int i = 0; i < n; i++) {
            coordinates[i] = bufferedReader.readLine();
        }

        
    }
}
