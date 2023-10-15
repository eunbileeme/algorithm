import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[] visited;
    private static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i ++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // ※ 무방향 그래프 특성
            map[x][y] = 1;
            map[y][x] = 1;
        }

        cnt = 0;
        for (int i = 1; i <= n; i ++) {
            if (visited[i] == false) {
                dfs(i);
                cnt ++;
            }
        }

        System.out.println(cnt);
        br.close();
    }

    private static void dfs(int node) {
        if (visited[node] == true) {
            return;
        }

        visited[node] = true;

        for (int i = 1; i <= n; i ++) {
            if (map[node][i] == 1) {
                dfs(i);
            }
        }
    }
}