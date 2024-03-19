package secondLR.three;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] dots = new int[n][2];
        for (int i = 0; i < dots.length; i++) {
            String[] xy = scanner.nextLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            int[] intXY = new int[]{x, y};
            dots[i] = intXY;
        }

        double perimeter = findPerimeter(dots);
        String result = String.format("%.2f", perimeter);
        System.out.println(result);
    }

    private static double findPerimeter(int[][] a) {
        int n = a.length;
        int[] p = new int[n];
        //будем работать с индексами точек
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (int i = 1; i < n; i++) { // ищем начальную точку x, которая левее всех
            if (a[p[i]][0] < a[p[0]][0]) {
                int temp = p[i];
                p[i] = p[0];
                p[0] = temp;
            }
        }

        //сортируем точки (вставками + проверкой)
        for (int i = 2; i < n; i++) {// начинаем со второй точки потому что первая левее всех
            int j = i;
            while (j > 1 && (rotate(a[p[0]], a[p[j - 1]], a[p[j]]) < 0)) {// если наши точку которая правее от вектора аб то меняем ее местами с б
                int temp = p[j];
                p[j] = p[j - 1];
                p[j - 1] = temp;
                j--;
            }
        }

        //отбираем точки, срезаем углы
        Stack<Integer> s = new Stack<>();
        s.add(p[0]);
        s.add(p[1]); // так как эти 2 точки гарантированно будут первыми
        for (int i = 2; i < n; i++) {
            while (rotate(a[s.get(s.size() - 2)], a[s.get(s.size() - 1)], a[p[i]]) < 0) { // если точка справа
                s.pop();
            }
            s.push(p[i]);
        }
        //ищем периметр
        double perimeter = 0;
        int[] indexes = new int[s.size()];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = s.pop();
        }
        for (int i = 0; i < indexes.length - 1; i++) {
            int[] dot1 = a[indexes[i]];
            int[] dot2 = a[indexes[i + 1]];
            int x1 = dot1[0];
            int y1 = dot1[1];
            int x2 = dot2[0];
            int y2 = dot2[1];
            double dir = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
            perimeter += dir;
            if (i == indexes.length - 2) {
                int[] first = a[indexes[0]];
                int lastX1 = first[0];
                int lastY1 = first[1];
                int lastX2 = x2;
                int lastY2 = y2;
                double dirLast = Math.sqrt((lastX1 - lastX2) * (lastX1 - lastX2) + (lastY1 - lastY2) * (lastY1 - lastY2));
                perimeter += dirLast;
            }
        }

        return perimeter;
    }

    public static int rotate(int[] A, int[] B, int[] C) {//функция определяет, с какой стороны от вектора AB находится точка C
        //положительное возвращаемое значение соответствует левой стороне, отрицательное — правой от вектора аб
        return (B[0] - A[0]) * (C[1] - B[1]) - (B[1] - A[1]) * (C[0] - B[0]);
    }
}
