import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 입력 변수 초기화
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        // 2. 로직
        for (int i = 1; i < k + 1; i ++) {
            int element = Integer.parseInt(br.readLine());

            if (element == 0) {
                stack.pop();
            } else {
                stack.push(element);
            }
        }

        // 3. 출력
        int sum = 0;
        for (Integer e : stack) {
            sum += e;
        }

        System.out.println(sum);
        br.close();
    }
}
