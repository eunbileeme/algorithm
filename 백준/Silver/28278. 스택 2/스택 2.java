import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 입력 변수 초기화
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // 2. 스택
        for (int i = 1; i < n + 1; i++) {
            String[] commands = br.readLine().split(" ");

            if (commands.length > 1) {
                int element = Integer.parseInt(commands[1]);
                stack.push(element);

            } else {
                if (commands[0].equals("2")) {
                    if (!stack.isEmpty()) {
                        sb.append(stack.peek()).append('\n');
                        stack.pop();
                    } else {
                        sb.append(-1).append('\n');
                    }
                }

                else if (commands[0].equals("3")) {
                    sb.append(stack.size()).append('\n');
                }

                else if (commands[0].equals("4")) {
                    if (stack.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                }

                else {
                    if (!stack.isEmpty()) sb.append(stack.peek()).append('\n');
                    else sb.append(-1).append('\n');
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
