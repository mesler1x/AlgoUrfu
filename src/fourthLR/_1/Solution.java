package fourthLR._1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/mesler/Рабочий стол/AlgoUrfu/src/fourthLR/_1/input.txt"));
        String[] firstLine = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int[] arr = new int[n];
        String[] operations = new String[m];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 0; i < m; i++) {
            operations[i] = bufferedReader.readLine();
        }

        for (int i = 0; i < m; i++) {
            if (operations[i].split(" ")[0].equals("2")) {
                found(arr, operations[i]);
            } else {
                System.out.println(found(arr, operations[i]));
            }
        }
    }

    private static int found(int[] arr, String operation) {
        int type = Integer.parseInt(operation.split(" ")[0]);
        int startIndex = Integer.parseInt(operation.split(" ")[1]);
        int endIndex = Integer.parseInt(operation.split(" ")[2]);
        int sum = 0;
        if (type == 2) {
            arr[startIndex] = endIndex;
        } else {
            for (int i = startIndex; i <= endIndex; i++) {
                sum += arr[i];
            }
        }
        return sum;
    }
}
