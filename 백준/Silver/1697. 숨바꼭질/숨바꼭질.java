import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n = 0;
    private static int k = 0;
    private static int[] visited;
    private static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 1. 초기화
        visited = new int[100001];

        // 2. 탐색
        time = bfs(n);

        // 3. 출력
        System.out.println(time);
        br.close();
    }

    private static int bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = 1;

        while (!q.isEmpty()) {
            int location = q.poll();

            if (location == k) {
                return visited[location] - 1;
            }

            if (location - 1 >= 0 && visited[location - 1] == 0) {
                visited[location - 1] = visited[location] + 1; // 시간을 구해야하므로 + 1
                q.offer(location - 1);
            }

            if (location + 1 <= 100000 && visited[location + 1] == 0) {
                visited[location + 1] = visited[location] + 1;
                q.offer(location + 1);
            }

            if (location * 2 <= 100000 && visited[location * 2] == 0) {
                visited[location * 2] = visited[location] + 1;
                q.offer(location * 2);
            }
        }

        return -1;
    }
}
