package _3LR._12;

import java.util.*;

public class Tree {
    Map<Integer, List<Integer>> graph;

    public Tree(int n) {
        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int parent, int child) {
        graph.get(parent).add(child);
        graph.get(child).add(parent);
    }

    public int findNode(int start, int dist) {
        Queue queue = new Queue();
        //массив посещений
        boolean[] visited = new boolean[graph.size()];
        //массив дистанций всех точек начиная от первой
        int[] distance = new int[graph.size()];
        //инициализируем очередь стартовой точкой
        queue.add(start);

        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            //брем текущую точку и идём по всем вершинам которые смежны с ней
            int node = queue.remove();
            for (int neighbor : graph.get(node)) {
                //если мы не посетили соседа
                if (!visited[neighbor]) {
                    // если дистанция от соседа до нашей вершины равна искомой дистанции то ВСЁ!
                    if (distance[node] + 1 == dist) {
                        return neighbor;
                    }

                    //иначе посещяем и считаем дистацию
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    //добавляем в очередь тех кто не подошел
                    queue.add(neighbor);
                }
            }
        }
        return 0;
    }
    public static void main (String[]args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        Tree tree = new Tree(n);
        for (int i = 0; i < n - 1; i++) {
            int parent = scanner.nextInt();
            int child = scanner.nextInt();
            tree.addEdge(parent, child);
        }
        for (int i = 0; i < q; i++) {
            int vi = scanner.nextInt();
            int di = scanner.nextInt();
            int result = tree.findNode(vi, di);
            System.out.println(result);
        }
    }
}