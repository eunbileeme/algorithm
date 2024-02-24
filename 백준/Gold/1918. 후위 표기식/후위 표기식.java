import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

// TODO 1. '*' 또는 '/'를 마주했을 경우, 해당 연산자를 기준으로 -2 / + 2의 위치에 소괄호 삽입?

// TODO 이 문제는 소괄호도 쳐줘야 했던거 아니야?
// TODO (1) 우선 순위를 어떻게 할당할 것인가?
// TODO (2) 스택에 넣고 빼는 과정을 어떤 조건을 기준으로 분리할 것인가?
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String infixNotation = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        char[] chars = infixNotation.toCharArray();
        for (int i = 0; i < infixNotation.length(); i++) {
            int priority = getPriority(chars[i]);

            switch (chars[i]) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && getPriority(stack.peek()) >= priority) {
                        sb.append(stack.pop());
                    }

                    stack.push(chars[i]);
                    break;

                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }

                    stack.pop();
                    break;

                case '(':
                    stack.push('(');
                    break;

                default:
                    sb.append(chars[i]);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
        br.close();
    }

    private static int getPriority(char ch) {
        switch (ch) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
}
