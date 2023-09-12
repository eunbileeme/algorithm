import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i ++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            
            int tmp = 0;
            tmp = queue.peek();
            
            queue.poll();
            queue.add(tmp);
        }

        System.out.println(queue.peek());

        br.close();
    }
}