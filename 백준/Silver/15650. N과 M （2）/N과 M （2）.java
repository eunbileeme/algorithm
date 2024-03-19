import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// Todo 이전 인덱스를 기억하고 있어야 하므로 "백트래킹"을 사용
// Todo N과 M이 주어지고, 중복되는 수를 제외한 모든 경우의 수를 탐색 -> 재귀 (DFS)
// Todo "1부터 N까지의 수 중 오름차순이면서 M의 길이까지 나열 가능한 수열"

// Todo 어떠한 수를 depth 즉 깊이로 두고 풀 것인가?
// Todo 백트래킹 : 충족되지 않은 조건을 탈락시키는 알고리즘 -> 탐색을 할 때, 범위를 점점 줄여나가는 것
// Todo depth : 배열이라는 고정적인 크기를 가진 자료구조를 탐색하는 기준
public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int n, m;
    private static boolean[] visited;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // visited[0 ~ n] -> 인덱스
        // 1부터 탐색을 하지만, 배열 기준으로 인덱스가 1인 곳부터 탐색을 하는 것이므로 n + 1
        visited = new boolean[n + 1]; // 탐색한 노드(= 인덱스)를 방문했는지 안했는지의 여부, 가지치기의 조건
        arr = new int[m];

        dfs(0, 1);

        System.out.println(sb);
        br.close();
    }

    private static void dfs(int depth, int start) {
        if (depth == m) {
            for (int val : arr) { // val : 출력할 노드(값)
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i; // 출력을 기준으로 첫 번째 열을 정함 (ex. depth = 0, arr[0] = 1 -> depth : 1, arr[1] = 2 -> sb.append(1)

                dfs(depth + 1, i + 1); // arr은 출력용 노드들을 담아놓은 배열이므로 중복되는 수열을 여러 번 출력하지 않기 위해, start + 1을 해줘야

                visited[i] = false;
            }
        }
    }
}