package firstLR.two;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        twoMissives();
    }
    public static void twoMissives(){
        Scanner scanner = new Scanner(System.in);
        int[] size = new int[2];
        String twoSizes = scanner.nextLine();
        size[0] = Integer.parseInt(twoSizes.split(" ")[0]);
        size[1] = Integer.parseInt(twoSizes.split(" ")[1]);
        int[] arrA = new int[size[0]];
        for (int i = 0; i < size[0]; i++) {
            arrA[i] = scanner.nextInt();
        }

        int[] arrB = new int[size[1]];
        for (int i = 0; i < size[1]; i++) {
            arrB[i] = scanner.nextInt();
        }


        int res = countSameElements(arrA, arrB);
        System.out.println(res);
    }

    public static int countSameElements(int[] arrA, int[] arrB){
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arrA.length && j < arrB.length){
            if (arrA[i] < arrB[j]){
                i++;
            }
            else if (arrA[i] == arrB[j]){
                res++;
                i++;
                j++;
            }
            else if (arrA[i] > arrB[j]){
                j++;
            }
        }


        return res;
    }


}
