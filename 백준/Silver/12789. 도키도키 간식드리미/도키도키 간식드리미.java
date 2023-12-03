import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 입력 변수 초기화
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();

        // 2. 대기열
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        // 3. 로직
        int start = 1;

        while (!q.isEmpty()) {
            if (q.peek() == start) {
                q.poll();
                start++;
            } else if (!s.isEmpty() && s.peek() == start) {
                s.pop();
                start++;
            } else {
                s.push(q.poll());
            }
        }

        // 4. 추가 대기열
        while (!s.isEmpty()) {
            if (s.peek() == start) {
                s.pop();
                start++;
            } else {
                System.out.println("Sad");
                return;
            }
        }

        System.out.println("Nice");
        br.close();
    }
}
