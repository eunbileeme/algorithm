import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 입력 변수 초기화
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int push = 0;

        // 2. 로직
        for (int i = 1; i < n + 1; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                push = value;
                q.add(value);
            } else if (command.equals("pop")) {
                if (q.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    int poll = q.poll();
                    sb.append(poll).append('\n');
                }
            } else if (command.equals("size")) {
                sb.append(q.size()).append('\n');
            } else if (command.equals("empty")) {
                if (q.isEmpty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if (command.equals("front")) {
                if (q.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    int front = q.peek();
                    sb.append(front).append('\n');
                }
            } else {
                if (q.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    if (q.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        int back = push;
                        sb.append(back).append('\n');
                    }
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
