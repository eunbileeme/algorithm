import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 최대힙
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i ++) {
            int tmp = Integer.parseInt(br.readLine());

            if (tmp == 0) {
                if (pq.isEmpty()) System.out.println("0");
                else System.out.println(pq.poll());
            } else {
                pq.add(tmp);
            }
        }

        br.close();
    }
}