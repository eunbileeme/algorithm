import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int x, y;
    private static int[][] map;
    // private static boolean[][] visited;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        y = Integer.parseInt(st.nextToken()); // 가로 = 열
        x = Integer.parseInt(st.nextToken()); // 세로 = 행

        // 1. 초기화
        map = new int[x][y];

        // 2. 입력
        for (int r = 0; r < x; r ++) {
            // 공백을 고려해야 함
            String[] row = br.readLine().split(" ");
            for (int c = 0; c < y; c ++) {
                int num = Integer.parseInt(row[c]);
                map[r][c] = num;

                // map 정보를 입력함과 동시에
                // 1인 위치값들을 큐에 미리 삽입
                if (num == 1) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        // 3. 탐색 및 출력
       System.out.println(bfs());
       br.close();
    }

    private static int bfs() {

        while (! q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            int distance = 4;

            for (int k = 0; k < distance; k++) {
                int nx = r + dx[k];
                int ny = c + dy[k];

                if (nx >= 0 && nx < x && ny >= 0 && ny < y) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = map[r][c] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return checkTomatoNumber();
    }

    private static int checkTomatoNumber() {
        // 연산이 끝나지 않은 상태에서 확인하는 것이므로
        // 0이 아닌 상수 사용
        int max = Integer.MIN_VALUE;
        if (isZero()) {
            return - 1;
        } else {
            for (int r = 0; r < x; r ++) {
                for (int c = 0; c < y; c ++) {
                    if (max < map[r][c]) {
                        max = map[r][c];
                    }
                }
            }

            // 큐에 첫 번째로 넣은 시작점은 0일로 간주해야 함
            return max - 1;
        }
    }

    private static boolean isZero() {
        for (int r = 0; r < x; r ++) {
            for (int c = 0; c < y; c ++) {
                if (map[r][c] == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
