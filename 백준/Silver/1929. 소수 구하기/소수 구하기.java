import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // ※ m ~ n까지 범위에서 소수를 찾는 문제이므로
        // i는 m부터 n까지 탐색
        for (int i = m; i <= n; i ++) {
            boolean isPrime = true;
            if (i == 1)
                continue;
            // ※ i = 4일 경우, 4의 제곱근인 2까지 탐색을 수행해야
            // 소수가 아님을 알 수 있으므로
            // 해당 제곱근까지 포함해서 순회
            for (int j = 2; j <= Math.sqrt(i); j ++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                System.out.println(i);
        }

        br.close();
    }
}
