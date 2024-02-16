import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<Node>> tree; // <-> ArrayList<Node>[] tree;
    static boolean[] visited;
    static int randomlyNode = 0;
    static int maxDistance = 0;

    static class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 노드의 개수

        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // 0 ~ n - 1, ex. 노드는 12개지만 1부터 입력할 것이므로 총 13개를 생성
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) { // 1 ~ n - 1, ex. 노드는 12개, 간선은 11개
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parentNode = Integer.parseInt(st.nextToken());
            int childNode = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            tree.get(parentNode).add(new Node(childNode, distance));
            tree.get(childNode).add(new Node(parentNode, distance));
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        maxDistance = 0;
        dfs(randomlyNode, 0);

        System.out.println(maxDistance);
    }

    // TODO 아래 부분 복기하기
    private static void dfs(int current, int distance) {
        visited[current] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            randomlyNode = current;
        }

        for (Node node : tree.get(current)) {
            if (!visited[node.index]) {
                dfs(node.index, distance + node.distance);
            }
        }
    }
}
