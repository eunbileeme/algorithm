import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int m;

    public static int[][] arr;
    public static boolean[][] visited;
    // ※ 내가 제일 어려워하는 부분
    // ※
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // n
        m = Integer.parseInt(st.nextToken()); // m

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = row.charAt(j) - '0';
            }
        }

        visited[0][0] = true;

        bfs(0, 0);

        System.out.println(arr[n - 1][m - 1]);
        br.close();
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int nx = node[0];
            int ny = node[1];

            // ※
            for (int i = 0; i < 4; i++) {
                int nextX = nx + dx[i];
                int nextY = ny + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (arr[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        q.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        arr[nextX][nextY] = arr[nx][ny] + 1;
                    }
                }
            }
        }
    }
}
