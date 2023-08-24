import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // ※ 문자열로 조건문을 확인해야하므로, 해당 문자열을 변수에 따로 보관
            String str = st.nextToken();
            if (str.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (str.equals("top")) {
                if (stack.size() == 0)
                    System.out.println(-1);
                else
                    System.out.println(stack.peek()); // 출력해야
            } else if (str.equals("size")) {
                System.out.println(stack.size()); // 출력해야
            } else if (str.equals("empty")) {
                if (stack.isEmpty() == true)
                    System.out.println(1);
                else
                    System.out.println(0);
            } else {
                if (stack.size() == 0)
                    System.out.println(-1);
                else
                    System.out.println(stack.pop()); // 출력해야
            }
        }

        br.close();
    }
}