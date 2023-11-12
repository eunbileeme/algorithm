import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dx = {-1, 0, 1, 0, 0, 0}; // 상, 우, 하, 좌, 위, 아래
    private static final int[] dy = {0, 1, 0, -1, 0, 0};
    private static final int[] dz = {0, 0, 0, 0, -1, 1};
    private static int[][][] map;
    private static int x, y, z;
    private static final Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        y = Integer.parseInt(st.nextToken()); // 가로 = 열
        x = Integer.parseInt(st.nextToken()); // 세로 = 행
        z = Integer.parseInt(st.nextToken());

        // 1. 초기화
        map = new int[z][x][y];

        // 2. 입력
        for (int h = 0; h < z; h++) {
            for (int r = 0; r < x; r++) {
                String[] row = br.readLine().split(" ");
                for (int c = 0; c < y; c++) {
                    map[h][r][c] = Integer.parseInt(row[c]);

                    if (map[h][r][c] == 1) {
                        q.offer(new int[]{h, r, c});
                    }
                }
            }
        }

        // 3. 출력 및 탐색
        System.out.println(bfs());
        br.close();
    }

    private static int bfs() {

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int h = temp[0];
            int r = temp[1];
            int c = temp[2];
            int distance = 6;

            for (int k = 0; k < distance; k++) {
                int nz = h + dz[k];
                int nx = r + dx[k];
                int ny = c + dy[k];

                if (nz >= 0 && nz < z && nx >= 0 && nx < x && ny >= 0 && ny < y) {
                    if (map[nz][nx][ny] == 0) {
                        q.offer(new int[]{nz, nx, ny});
                        map[nz][nx][ny] = map[h][r][c] + 1;
                    }
                }
            }
        }

        return checkDays();
    }

    private static int checkDays() {
        int result = Integer.MIN_VALUE;

        for (int h = 0; h < z; h++) {
            for (int r = 0; r < x; r++) {
                for (int c = 0; c < y; c++) {
                    if (map[h][r][c] == 0) {
                        return -1;
                    }

                    result = Math.max(result, map[h][r][c]);
                }
            }
        }

        // 시작할 때부터 모든 토마토가 익어있는 상태
        if (result == 1) {
            return 0;
        } else {
            return result - 1;
        }
    }
}
