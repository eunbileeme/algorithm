import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while (!(str = br.readLine()).equals(".")) {
            sb.append(balance(str)).append('\n');
        }

        System.out.println(sb);

        br.close();
    }

    private static String balance(String str) {
        // ※ 케이스 5 -> 직전의 괄호를 기억하고 있어야 함(= 순서 중요)
        // ※ 케이스 6 -> 연속적으로 여는 괄호 또는 닫는 괄호가 들어오므로 현재 입력받은 괄호를 기준으로 이전의 모든 괄호들을 기억하고 있어야 함(= 순서 중요)
        // 따라서 위 경우에는 stack을 사용
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // ※ 여는 괄호는 무조건 stack에 저장
            if (c == '(' || c == '[') {
                stack.push(c);
            // ※ 닫는 소괄호가 들어왔을 경우
            } else if (c == ')') {
                // ※ stack이 비어있거나 최상단의 element가 여는 괄호가 아닐 경우(= 짝을 이룰 괄호가 없을 경우)
                if (stack.empty() || stack.peek() != '(') {
                    return "no";
                } else {
                    stack.pop();
                }
            // ※ 닫는 대괄호가 들어왔을 경우    
            } else if (c == ']') {
                if (stack.empty() || stack.peek() != '[') {
                    return "no";
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.empty()) return "yes";
        else return "no";
    }
}