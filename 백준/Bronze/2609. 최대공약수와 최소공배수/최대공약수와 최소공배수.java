import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] answer = new int[2];

        for (int i = 1; i <= m; i ++) {
            if (n % i == 0 && m % i == 0) {
                answer[0] = i;
            }
        }
        answer[1] = answer[0] * (n / answer[0]) * (m / answer[0]);

        System.out.println(answer[0]);
        System.out.println(answer[1]);

        br.close();
    }
}
