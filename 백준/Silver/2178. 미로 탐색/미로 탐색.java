import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int[][] map;
    private static boolean[][] visited;
    private static int n = 0;
    private static int m = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 1. 초기화
        map = new int[n][m];
        visited = new boolean[n][m];

        // 2. 값 추가
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        // 3. 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        // 4. 출력, 인덱스는 0부터 시작하므로 -1
        // 또는 최단 경로는 시작 지점을 제외하고 카운트하므로 -1
        System.out.println(map[n - 1][m - 1]);
    }

    // 인접행렬 - ver.Bfs
    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int cx = node[0];
            int cy = node[1];
            int distance = 4;

            for (int k = 0; k < distance; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        // 5. 최단 거리를 찾기 위한 거리 정보를 저장
                        map[nx][ny] = map[cx][cy] + 1;
                    }
                }
            }
        }
    }
}
