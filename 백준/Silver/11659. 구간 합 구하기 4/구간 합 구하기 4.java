import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 수의 개수 : n
        int m = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수 : m
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " "); // [5, 4, 3, 2, 1]
        int[] arr = new int[n + 1];
        // O(n)
        for (int i = 1; i < arr.length; i ++) {
            // arr[0] = 0
            // arr[1] = 0 + 5 = 5
            // arr[2] = 0 + 5 + 4 = 9
            // arr[3] = 0 + 5 + 4 + 3 = 12
            // arr[4] = 0 + 5 + 4 + 3 + 2 = 14
            // arr[5] = 0 + 5 + 4 + 3 + 2 + 1 = 15
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        // O(m)
        for (int i = 0; i < m; i ++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // arr[3] - arr[0] = (0 + 5 + 4 + 3) - 0 = 5 + 4 + 3 = 12
            // arr[4] - arr[1] = (5 + 4 + 3 + 2) - 5 = 4 + 3 + 2 = 9
            // arr[5] - arr[4] = (5 + 4 + 3 + 2 + 1) - (5 + 4 + 3 + 2) = 1
            sb.append(arr[b] - arr[a - 1]).append('\n');
        }

        // 총 시간 복잡도 : O(n + m)
        System.out.println(sb);
        br.close();
    }
}