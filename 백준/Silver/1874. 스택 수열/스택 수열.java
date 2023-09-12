import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // ※ 1. 스택에 값을 넣는다.
        // ※ 2. 스택에서 값을 뺀다.
        // ※ 3. 결과 스택에 값을 넣어서 비교한다.
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        int start = 0;
        // ※ (후위 감소 연산) n이 0보다 클 동안 반복하고, 각 반복 후 n을 -1
        while(n -- > 0) {
            int value = Integer.parseInt(br.readLine());

            // ※ start + 1부터 입력받은 value까지 push
            if (value > start) {
                for (int i = start + 1; i <= value; i ++) {
                    // ※ i 값 자체를 push 하는 방식으로 진행
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                // ※ 다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화 = 이어서 push
                start = value;
            } else if (stack.peek() != value) {
                System.out.println("NO");
                // ※ return != break
                return;
            }

            // ※ 삽입 후, operator를 판별하기 위해 즉시 빼야
            stack.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);

        br.close();
    }
}