import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int k;
    public static int[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new int[100001];

        if (n == k) {
            System.out.println(0);
        } else {
            bfs(n);
        }

        br.close();
    }

    private static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < 3; i++) {
                int next = 0;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if (next == k) {
                    System.out.println(visited[temp]);
                    return;
                }

                if (next >= 0 && next < visited.length && visited[next] == 0) {
                    q.add(next);
                    visited[next] = visited[temp] + 1;
                }
            }
        }
    }
}