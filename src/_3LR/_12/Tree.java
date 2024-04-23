package _3LR._12;

import java.util.*;

public class Tree {
    Map<Integer, List<Integer>> graph;

    public Tree(int n) {
        graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int parent, int child) {
        graph.get(parent).add(child);
        graph.get(child).add(parent);
    }

    public int findNode(int start, int dist) {
        Queue queue = new Queue(100);
        boolean[] visited = new boolean[graph.size()];
        int[] distance = new int[graph.size()];
        queue.add(start);
        visited[start - 1] = true;
        distance[start - 1] = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor - 1]) {
                    if(distance[node - 1] + 1 == dist) return neighbor;
                    visited[neighbor - 1] = true;
                    distance[neighbor - 1] = distance[node - 1] + 1;
                    queue.add(neighbor);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
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