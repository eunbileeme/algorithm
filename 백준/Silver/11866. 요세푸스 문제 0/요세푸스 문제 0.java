import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i ++) {
            queue.add(i);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i ++) {
                // ※ k-1 번째까지 값을 하나씩 제거 후, 삽입함으로써 뒤로 보냄
                queue.add(queue.poll());
            }
            // ※ k번째 값을 ArrayList에 저장
            answer.add(queue.poll());
        }

        System.out.print("<");
        for (int i = 0; i < answer.size(); i ++) {
            System.out.print(answer.get(i));
            if (i != answer.size() - 1)
                System.out.print(", ");
        }
        System.out.print(">");

        br.close();
    }
}