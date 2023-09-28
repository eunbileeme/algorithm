import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 개수(4)
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수(5)
        int v = Integer.parseInt(st.nextToken()); // 정점의 번호(1)

        /*
        * graph
        * [[]]
        * [[], []]
        * [[], [], []]
        * [[], [], [], []]
        * [[], [], [], [], []]
        */

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            /*
            * [[], [2], [], [], []]
            * [[], [2, 3], [1], [], []]
            * [[], [2, 3, 4], [1], [1], []]
            * [[], [2, 3, 4], [1, 4], [1], [1]]
            * [[], [2, 3, 4], [1, 4], [1, 4], [1, 2]]
            */

            graph.get(node1).add(node2);

            /*
             * [[], [2], [1], [], []]
             * [[], [2, 3], [1], [1], []]
             * [[], [2, 3, 4], [1], [1], [1]]
             * [[], [2, 3, 4], [1, 4], [1], [1, 2]]
             * [[], [2, 3, 4], [1, 4], [1, 4], [1, 2, 3]]
             */

            graph.get(node2).add(node1); // 양방향
        }

        // ※ 이웃 정점들을 오름차순으로 정렬
        // -> [[], [2, 3, 4], [1, 4], [1, 4], [1, 2, 3]]
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        // ※ 인덱스는 0부터 시작하지만, 정점은 1부터 시작하므로 + 1
        visited = new boolean[n + 1];

        dfs(v);
        sb.append('\n');
        Arrays.fill(visited, false);

        bfs(v);

        System.out.println(sb);
        br.close();
    }

    private static void dfs(int node) {
        visited[node] = true;
        sb.append(node + " ");

        for (int adjNode : graph.get(node)) {
            if (!visited[adjNode]) {
                dfs(adjNode);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node + " ");

            for (int adjNode : graph.get(node)) {
                if (!visited[adjNode]) {
                    queue.offer(adjNode);
                    visited[adjNode] = true;
                }
            }
        }
    }
}
