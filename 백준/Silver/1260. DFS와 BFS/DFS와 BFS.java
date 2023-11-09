import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // 1. 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 2. 간선 정보 추가
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        // 3. 초기화
        visited = new boolean[n + 1];

        // 4. 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        // 5. dfs
        dfs(v);

        sb.append('\n');

        // 6. 재초기화
        Arrays.fill(visited, false);

        // 7. bfs
        bfs(v);

        System.out.println(sb);
        br.close();
    }

    private static void dfs (int node) {
        visited[node] = true;
        sb.append(node + " ");

        for (int adjNode : graph.get(node)) {
            if (!visited[adjNode]) {
                dfs(adjNode);
            }
        }
    }

    private static void bfs (int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);

        visited[node] = true;

        while (!q.isEmpty()) {
            int tempNode = q.poll();
            sb.append(tempNode + " ");

            for (int adjNode : graph.get(tempNode)) {
                if (!visited[adjNode]) {
                    q.offer(adjNode);
                    visited[adjNode] = true;
                }
            }
        }
    }
}
