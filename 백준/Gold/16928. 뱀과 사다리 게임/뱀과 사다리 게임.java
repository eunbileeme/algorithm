import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] board;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // 사다리의 수
        m = Integer.parseInt(st.nextToken()); // 뱀의 수

        // 1. 초기화
        board = new int[101];
        visited = new int[101];

        for (int i = 0; i < board.length; i++) {
            board[i] = i; // idx = value
        }

        // 2. 입력
        // 사다리의 정보와 뱀의 정보를 의미하는 값들을 각각(= n번만큼 / m번만큼 반복하여) 채워야 함

        // n이 0보다 클 때까지 반복
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x] = y;
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x] = y;
        }

        // 3. 탐색
        int result = bfs(1);

        // 4. 출력
        System.out.println(result);
        br.close();
    }

    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 0;

        // !q.isEmpty()처럼 조건이 성립할 때 실행되는 것이 아닌, 항상 실행되는 반복문
        // 이 문제에서는 어느 경우에서든 100번째 칸에 도착
        // 따라서 (정확히는) 조건을 true로 설정
        while (true) {
            int temp = q.poll();

            for (int i = 1; i < 7; i++) {
                int destination = temp + i;

                if (destination > 100) continue;

                if (visited[board[destination]] == 0) {
                    q.offer(board[destination]);
                    visited[board[destination]] = visited[temp] + 1;
                }

                if (board[destination] == 100) return visited[100];
            }
        }
    }
}
