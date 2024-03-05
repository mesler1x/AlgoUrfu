package Pract1;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

    }

    public void mergeSort(int[] array, int left, int right){
        if (left == right) return;
        mergeSort(array, left, (left + right)/2);
        mergeSort(array, (left + right) / 2 + 1, right);
        merge(array, left, (left + right) / 2, right);
    }

    public void merge(int[] array, int left, int middle, int right){
        int first = left;
        int second = middle + 1;
        Queue<Integer> queue = new ArrayDeque<>();
        while (first <= middle && second <= right){
            if (array[first] < array[second]){
                queue.add(array[first]);
                first++;
            } else if (array[second] < array[first]){
                queue.add(array[second]);
                second++;
            }
        }

        while (first <= middle){
            queue.add(array[first]);
            first++;
        }

        while (second <= right){
            queue.add(array[second]);
            second++;
        }

        for (int i = left; i < right; i++) {
            array[i] = queue.poll();
        }
    }

    private int slice(int[] arr, int l, int r) {
        return 0;
    }
}
