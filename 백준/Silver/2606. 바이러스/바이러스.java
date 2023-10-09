import java.io.*;
import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n : 컴퓨터의 수
        int m = Integer.parseInt(br.readLine()); // m : 간선의 수
        count = 0;

        // 그래프 생성
        for (int i = 0; i <= n; i ++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 정보 입력
        for (int i = 0; i < m; i ++) {
            String[] str = br.readLine().split(" ");

            int node1 = Integer.parseInt(str[0]);
            int node2 = Integer.parseInt(str[1]);

            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        // 이웃 정점들을 오름차순으로 정렬
        for (int i = 1; i <= n; i ++) {
            Collections.sort(graph.get(i));
        }

        // 컴퓨터가 1부터 시작하므로..
        visited = new boolean[n + 1];

        dfs(1);

        System.out.println(count);
        br.close();
    }

    private static void dfs(int node) {
        visited[node] = true;

        // adjNode : 인접 노드
        for (int adjNode : graph.get(node)) {
            if (!visited[adjNode]) {
                dfs(adjNode);
                count ++;
            }
        }
    }
}
