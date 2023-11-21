import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static final int RED = 1;
    private static ArrayList<ArrayList<Integer>> graph;
    private static int[] colors;
    private static int k, v, e;
    private static boolean answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 변수 초기화
        k = Integer.parseInt(br.readLine());

        // 2. 입력
        for (int t = 0; t < k; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            // 3. 초기화
            answer = true;
            colors = new int[v + 1];
            graph = new ArrayList<>();

            for (int i = 0; i < v + 1; i++) {
                graph.add(new ArrayList<>());
            }

            // 4. 연결
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                // 무방향 그래프
                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            // 6. 탐색
            for (int i = 1; i < v + 1; i++) {
                if (colors[i] == 0) {
                    if (dfs(i, RED)) break;
                }
            }

            // 7. 출력
            System.out.println(answer ? "YES" : "NO");
        }

        br.close();
    }

    private static boolean dfs(int start, int color) {
        colors[start] = color; // = visited[node] = true;

        for (int adjNode : graph.get(start)) {
            // 인접 정점의 색이 같으면 이분 그래프가 아니며 함수를 바로 종료
            if (colors[adjNode] == color) {
                answer = false;
                return true;
            }

            if (colors[adjNode] == 0) {
                // 아직 방문하지 않았던 정점에 대해서 현재 정점과 다른 색상을 칠함
                if (dfs(adjNode, -color)) return true;
            }
        }

        return false;
    }
}