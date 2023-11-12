import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 나이트는 (2, 1) 또는 (1, 2)로 이동 가능
    // 이때, 방향은 상관이 없음
    // 따라서 탐색 가능한 모든 경우의 수로 구성
    private static final int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    private static final int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};
    private static final StringBuilder sb = new StringBuilder();
    private static int[][] map;
    private static boolean[][] visited;
    private static int l;
    private static int sX, sY, dX, dY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 테스트케이스
        int t = Integer.parseInt(br.readLine());

        // 2. 테스트케이스마다 수행
        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());

            // 3. 초기화
            map = new int[l][l];
            visited = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            sX = Integer.parseInt(st.nextToken());
            sY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            dX = Integer.parseInt(st.nextToken());
            dY = Integer.parseInt(st.nextToken());

            // 4. 탐색
            bfs();

            sb.append(map[dX][dY]).append('\n');
        }

        // 5. 출력
        System.out.println(sb);
        br.close();
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sX, sY});
        visited[sX][sY] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int cx = point[0];
            int cy = point[1];
            int distance = 8; // (2, 1), (2, -1), (-2, 1), (-2, -1), ..

            for (int k = 0; k < distance; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];

                if (nx >= 0 && nx < l && ny >= 0 && ny < l) {
                    if (!visited[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        map[nx][ny] = map[cx][cy] + 1;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
