import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i ++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp != 0) {
                stack.push(tmp);
            }
            if (tmp == 0) {
                stack.pop();
            }
        }

        int sum = 0;
        int size = stack.size();
        for (int i = 0; i < size; i ++) {
            if (stack.size()  == 0) {
                System.out.println(0);
            } else {
                sum += stack.peek();
                stack.pop();
            }
        }

        System.out.println(sum);
    }
}