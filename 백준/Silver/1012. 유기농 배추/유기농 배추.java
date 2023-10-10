import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static int k;
    public static int[][] map;
    public static boolean[][] visited;
    // ※ 상 우 하 좌
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    private static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // t : 테스트 케이스의 개수

        // 지도 입력
        for (int i = 0; i < t; i ++) {
            String[] str = br.readLine().split(" ");
            m = Integer.parseInt(str[1]); // m : 맵의 가로 길이 = 열
            n = Integer.parseInt(str[0]); // n: 맵의 세로 길이 = 행
            int k = Integer.parseInt(str[2]); // k : 배추가 심어져 있는 위치의 개수
            answer = 0;

            map = new int[n][m];
            visited = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                String[] point = br.readLine().split(" ");
                int w = Integer.parseInt(point[1]);
                int h = Integer.parseInt(point[0]);

                map[h][w] = 1;
            }

            // ※ 1의 입력을 다 받은 직후, 탐색을 진행 -> 즉, 해당 loop가 끝난 후 이어서 새 loop 진행
            // ※ 하나의 loop 안에서 진행할 경우, 입력을 다 받지 못한 상태에서 탐색을 수행하여 NullPointException 발생
            // ※ 중첩 loop로 실행할 이유는 또 없음..
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (!visited[x][y] && map[x][y] == 1) {
                        // ※ answer = 0;
                        answer ++; // ※ 1의 범위를 세는 변수, 아래의 dfs()를 수행 = 현재 1의 범위를 다 탐색한 후, 다음 1의 범위를 탐색하겠다는 뜻
                        dfs(x, y);
                        // ※ System.out.println(answer); -> 3 2 2 1 9
                    }
                }
            }

            System.out.println(answer);
        }

        br.close();
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
