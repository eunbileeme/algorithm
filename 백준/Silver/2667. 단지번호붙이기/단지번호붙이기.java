import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int apartNum = 0;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] apart = new int[25 * 25]; // ※ 지도에서 가질 수 있는 단지의 총 집의 수
    private static int dx[] = {-1, 1, 0, 0};
    private static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        // 1. 전체 map 입력 받기
        for (int i = 0; i < n; i ++) {
            String row = br.readLine();
            for (int j = 0; j < n; j ++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        // 2. 영역이 분리되어 있는 아직 방문하지 않은 1부터 탐색 시작..
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    apartNum ++;
                    bfs(i, j);
                }
            }
        }

        Arrays.sort(apart);
        System.out.println(apartNum);

        // 3. 1차원 배열 answer에서 각 단지 내 집의 수를 출력
        for (int i = 0; i < apart.length; i ++) {
            if (apart[i] != 0)
                System.out.println(apart[i]);
        }
    }

    private static void bfs(int x, int y) {
        Queue<int []> q = new LinkedList<>();
        q.add(new int[] {x, y});

        visited[x][y] = true;
        apart[apartNum] ++;

        while (!q.isEmpty()) {
            int curX = q.peek()[0];
            int curY = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i ++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        q.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                        apart[apartNum] ++;
                    }
                }
            }
        }
    }
}
