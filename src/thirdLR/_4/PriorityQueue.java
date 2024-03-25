package thirdLR._4;

import java.util.*;

public class PriorityQueue {
    List<Integer> heap;
    Map<Integer, Integer> map = new TreeMap<>();

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
    }
}
