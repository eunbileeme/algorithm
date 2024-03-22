import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();

        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        boolean inTag = false;

        // 1. 태그인가? 문자열인가? 공백인가?
        // 1-1) 태그?
        // 1-2) 문자열? 태그 안 or 태그 밖
        // 1-3) 공백? 태그 안 or 태그 밖
        // ---
        // 태그인가? < >
        // 태그 안인가?(공백이든, 문자열이든 그냥 결과값에 추가하면 된다.)
        // 태그 밖인가?(공백이면 뒤집은 문자열 결과값에 추가하고, 문자열이면 스택에 넣는다)
        while (idx < data.length()) {
            char c = data.charAt(idx++);

            if (c == '<') {
                // 리스트에 쌓인 문자를 뒤집어서 추가
                while (!list.isEmpty()) {
                    sb.append(list.remove(list.size() - 1));
                }
                inTag = true;
                sb.append(c);
            } else if (c == '>') {
                inTag = false;
                sb.append(c);
            } else if (inTag) {
                // 태그 내부에서는 그대로 문자 추가
                sb.append(c);
            } else {
                // 태그 밖에서 공백을 만나면 리스트에 쌓인 문자를 뒤집어서 추가
                if (c == ' ') {
                    while (!list.isEmpty()) {
                        sb.append(list.remove(list.size() - 1));
                        // sb.append(stack.pop())
                    }
                    sb.append(c);
                } else {
                    // 태그 밖에서 공백이 아닌 문자는 리스트에 추가
                    list.add(c);
                }
            }
        }

        // 마지막으로 리스트에 남은 문자들을 뒤집어서 추가
        while (!list.isEmpty()) {
            sb.append(list.remove(list.size() - 1));
        }

        System.out.println(sb.toString());
        sc.close();
    }
}