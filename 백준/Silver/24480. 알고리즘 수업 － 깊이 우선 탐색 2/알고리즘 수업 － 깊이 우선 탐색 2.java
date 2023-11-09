import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int[] result;
    private static int idx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        // 1. 그래프 초기화
        for (int i = 0; i <= n; i ++) {
            graph.add(new ArrayList<>());
        }

        // 2. 간선 정보 입력
        for (int i = 1; i <= m; i ++) {
            st = new StringTokenizer(br.readLine(), " ");

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        // 3. 정렬
        for (int i = 1; i <= n; i ++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        // 4. visited 초기화
        visited = new boolean[n + 1];
        result = new int[n + 1];

        // 5. dfs
        dfs(r);

        for (int i = 1; i < result.length; i ++) {
            System.out.println(result[i]);
        }
        br.close();
    }

    private static void dfs(int start) {
        visited[start] = true;
        idx ++;
        result[start] = idx;

        for (int adjNode : graph.get(start)) {
            if (!visited[adjNode]) {
                dfs(adjNode);
            }
        }
    }
}
