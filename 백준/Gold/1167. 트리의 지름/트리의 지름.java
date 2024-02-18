import java.io.*;
import java.util.*;

// TODO 예제 입력 1의 트리
// 1
// 3 (2)
// 4 (3)
// 2 (4) 5 (6)

// TODO 트리의 지름을 구하려면 임의의 정점(= 탐색하고 있는 현재 정점)으로부터 가장 먼 정점을 찾은 후. 거리를 구하면 됨
public class Main {
    static int v;
    static int result = 0;
    static int maxNode = 0;
    static ArrayList<Edge>[] nodes; // <-> ArrayList<ArrsyList<Edge>> 출력하여 비교해보기

    static class Edge { // 트리 저장용
        int end;
        int weight;

        private Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static class Node { // BFS 탐색용
        int idx;
        int distance;

        private Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());

        nodes = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i <= v; i++) {
            String[] inputs = br.readLine().split(" ");
            int idx = Integer.parseInt(inputs[0]);
            int j = 1;

            while (true) {
                int nodeNumber = Integer.parseInt(inputs[j]);
                if (nodeNumber == -1) {
                    break;
                }
                int weight = Integer.parseInt(inputs[j + 1]);

                nodes[idx].add(new Edge(nodeNumber, weight));
                j += 2;
            }
        }

        bfs(1);
        bfs(maxNode);

        System.out.println(result);
    }

    private static void bfs(int start) {
        boolean[] visited = new boolean[v + 1];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        visited[start] = true;

        // TODO 복기 예정
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.distance > maxDistance) {
                maxDistance = now.distance;
                maxNode = now.idx;
            }

            for (Edge e : nodes[now.idx]) {
                if (!visited[e.end]) {
                    visited[e.end] = true;
                    queue.add(new Node(e.end, now.distance + e.weight));
                }
            }
        }

        result = Math.max(result, maxDistance);
    }
}
