import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// ※ Deque<Integer> x -> Deque<int[]>
// ※ deque.addLast(deque.pollFirst()) = 오른쪽으로 이동 (순회)
public class Main {
    static int next;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 입력 변수 초기화
        int n = Integer.parseInt(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        // 2. 1번 풍선을 제외하고 입력
        sb.append("1").append(" ");
        int paper = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= n; i ++) {
            deque.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        // 3. 로직
        while(!deque.isEmpty()) {
            if (paper > 0) {
                // ※ Deque의 특정 인덱스까지 순회 -> for문의 range : paper
                for (int i = 1; i < paper; i ++) {
                    deque.addLast(deque.pollFirst());
                }

                int[] next = deque.pollFirst();
                paper = next[1]; // 다시 그 다음 풍선부터 터뜨리기
                sb.append(next[0]).append(" ");
                continue;
            }

            if (paper < 0) {
                for (int i = paper; i < -1; i ++) {
                    deque.addFirst(deque.pollLast());
                }

                int[] next = deque.pollLast();
                paper = next[1];
                sb.append(next[0]).append(" ");
            }
        }

        // 4. 출력
        System.out.println(sb);
        br.close();
    }
}
