package _3LR._4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PriorityQueue {
    List<Integer> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
        heap.add(0);// для того что бы работала математика
    }

    public void add(int val) {
        heap.add(val);
        int i = heap.size() - 1;

        // поднимаем элемент на верх пока он меньше чем его родитель
        // если элемент сверху больше то поднимаем
        while (i > 1 && heap.get(i) < heap.get(i / 2)) {
            int temp = heap.get(i);
            heap.set(i, heap.get(i / 2));
            heap.set(i / 2, temp);
            i = i / 2;
        }
        System.out.println("added");
    }

    public String pop() {
        if (heap.size() == 1) {
            return "*";
        }
        if (heap.size() == 2) {
            return String.valueOf(heap.remove(heap.size() - 1)); // equivalent to heap.remove(1)
        }

        int res = heap.get(1);
        heap.set(1, heap.remove(heap.size() - 1));
        int i = 1;
        //опускаем значение вниз
        while (2 * i < heap.size()) {
            if (2 * i + 1 < heap.size() && heap.get(2 * i + 1) < heap.get(2 * i) && heap.get(i) > heap.get(2 * i + 1)) {
                int tmp = heap.get(i);
                heap.set(i, heap.get(2 * i + 1));
                heap.set(2 * i + 1, tmp);
                i = 2 * i + 1;
            } else if (heap.get(i) > heap.get(2 * i)) {
                int tmp = heap.get(i);
                heap.set(i, heap.get(2 * i));
                heap.set(2 * i, tmp);
                i = 2 * i;
            } else {
                break;
            }
        }
        return String.valueOf(res);
    }


    public void replace(int element, int elementToReplace) {
        int index = 0;
        for (int i = 0; i < heap.size(); i++) {
            if (element == heap.get(i)) {
                index = i;
                break;
            }
        }
        heap.set(index, elementToReplace);
        int i = index;
        while (i > 1 && heap.get(i) < heap.get(i / 2)) {
            int temp = heap.get(i);
            heap.set(i, heap.get(i / 2));
            heap.set(i / 2, temp);
            i = i / 2;
        }
        System.out.println("replaced");
    }

    public static void main(String[] args) throws IOException {
        PriorityQueue queue = new PriorityQueue();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\mesle\\Desktop\\DEV\\AlgoUrfu\\src\\_3LR\\_4\\input.txt"));

        List<String> operations = new ArrayList<>();
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            operations.add(line);
        }

        for(String operaion : operations) {
            if (operaion.startsWith("A")) {
                queue.add(Integer.parseInt(operaion.split(" ")[1]));
            } else if (operaion.startsWith("D")) {
                String[] nums = operaion.split(" ");
                int index = Integer.parseInt(nums[1]);
                int number = Integer.parseInt(nums[2]);
                queue.replace(index, number);
            } else if (operaion.equals("X")) {
                String popResult = queue.pop();
                System.out.println(popResult);
            }
        }
    }
}
