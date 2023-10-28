import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
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