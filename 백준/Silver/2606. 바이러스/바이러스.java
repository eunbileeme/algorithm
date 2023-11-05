import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n : 컴퓨터의 수
        int k = Integer.parseInt(br.readLine()); // k : 네트워크 상에서 직접 연결되어 있는 컴퓨터의 수

        // 1. 그래프(객체) 초기화
        for (int i = 0; i <= n; i ++) {
            graph.add(new ArrayList<>());
        }

        // 2. 그래프(객체)에 값 추가
        for (int i = 0; i < k; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        /*
        * [[], [2, 5], [1, 3, 5], [2], [7], [1, 2, 6], [5], [4]]
        */

        // 3. 이웃 정점(노드)들을 오름차순으로 정렬
        for (int i = 1; i <= n; i ++) {
            Collections.sort(graph.get(i));
        }

        // 4. 방문 유무 초기화
        visited = new boolean[n + 1];

        // 5. dfs 수행
        dfs(1);

        System.out.println(sum);
        br.close();
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int adjNode : graph.get(node)) {
            if (!visited[adjNode]) {
                sum ++;
                dfs(adjNode);
            }
        }
    }
}
