package thirdLR._4;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\mesle\\Desktop\\DEV\\AlgoUrfu\\src\\thirdLR\\_4\\input.txt"));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] operations = new String[n];
        for (int i = 0; i < n; i++) {
            operations[i] = bufferedReader.readLine();
        }

        PriorityQueue priorityQueue = new PriorityQueue();
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].startsWith("A")) {
                int val = Integer.parseInt(operations[i].substring(2));
                priorityQueue.add(val);
            } else if (operations[i].startsWith("X")) {
                System.out.println(priorityQueue.pop());
            } else {
                String line = operations[i];
                int index = Integer.parseInt(line.split(" ")[1]);
                int element = Integer.parseInt(operations[index - 2].substring(2));
                int elementToReplace = Integer.parseInt(line.split(" ")[2]);
                priorityQueue.replace(element, elementToReplace);
            }
        }
    }
}
