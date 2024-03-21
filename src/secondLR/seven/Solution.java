package secondLR.seven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(line1[0]); // число отрезков
        int m = Integer.parseInt(line1[1]); // число точек
        int[][] segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] dots = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(dots[0]);
            int b = Integer.parseInt(dots[1]);
            int[] dot =new int[]{a, b};
            segments[i] = dot;
        }

        String[] linesDots = bufferedReader.readLine().split(" ");
        int[] dots = new int[linesDots.length];
        for (int i = 0; i < linesDots.length; i++) {
            dots[i] = Integer.parseInt(linesDots[i]);
        }

        int[] findDotsBelonging = findDotsBelonging(segments, dots);
        System.out.println(Arrays.toString(findDotsBelonging));
    }

    private static int[] findDotsBelonging(int[][] segments, int[] dots) {
        int[] findForEachDot = new int[dots.length];
        for (int i = 0; i < findForEachDot.length; i++) {
            int dot = dots[i];// берем точку и проверяем ее для каждого сегмента
            for (int[] segment : segments) {
                int a = segment[0];// первая точка отрезка
                int b = segment[1];// вторая точка отрезка
                if (Math.min(a, b) <= dot && Math.max(a, b) >= dot) { // если точка внутри отрезка
                    findForEachDot[i]++;
                }
            }
        }
        return findForEachDot;
    }
}
