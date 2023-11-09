import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 1. 그래프 초기화
        for (int i = 0; i <= n; i ++) {
            graph.add(new ArrayList<>());
        }

        // 2. 간선 정보 추가
        for (int i = 0; i < m; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        // 3. 정렬
        for (int i = 1; i <= n; i ++) {
            Collections.sort(graph.get(i));
        }

        // 4. 초기화
        visited = new boolean[n + 1];

        // 5. dfs
        dfs(1);

        // 6. 출력
        System.out.println(sum);
    }

    private static void dfs (int node) {
        visited[node] = true;

        for (int adjNode : graph.get(node)) {
            if (!visited[adjNode]) {
                sum ++;
                dfs(adjNode);
            }
        }
    }
}
