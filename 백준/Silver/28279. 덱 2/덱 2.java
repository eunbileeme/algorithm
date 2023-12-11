import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 입력 변수 초기화
        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 2. 로직
        // Todo 메서드로 분리 예정
        for (int i = 1; i < n + 1; i++) {
            String[] command = br.readLine().split(" ");

            if (command.length > 1) {
                int x = Integer.parseInt(command[1]);

                if (command[0].equals("1")) {
                    deque.addFirst(x);
                } else {
                    deque.addLast(x);
                }
            }

            else if (command[0].equals("3")) {
                if (!deque.isEmpty()) {
                    int tmp = deque.pop();
                    sb.append(tmp).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }
            }

            else if (command[0].equals("4")) {
                if (!deque.isEmpty()) {
                    int tmp = deque.removeLast();
                    sb.append(tmp).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }
            }

            else if (command[0].equals("5")) {
                sb.append(deque.size()).append('\n');
            }

            else if (command[0].equals("6")) {
                if (deque.isEmpty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }

            else if (command[0].equals("7")) {
                if (!deque.isEmpty()) {
                    sb.append(deque.peekFirst()).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }
            }

            else {
                if (!deque.isEmpty()) {
                    sb.append(deque.peekLast()).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }
            }
        }

        // 3. 출력
        System.out.println(sb);
        br.close();
    }
}