import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Todo br.readLine() 내의 R,G,B 값을 각각 0,1,2로 key-value 형태로 저장하고 싶었으나 실패
// Todo 나는 HashMap을 떠올렸는데, 어떻게 2차원 배열 + 누적합(예제 4)을 떠올릴 수 있었을까?

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][3]; // Todo i = 1부터 시작하므로..

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            // System.out.println("red : " + red);
            // System.out.println("green : " + green);
            // System.out.println("blue : " + blue);

            // Todo 재귀를 통해 if-else로 푸는 것이 아닌 반복문-Math.min()으로 푸는 방법
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + red;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + green;
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + blue;

            // System.out.println("R " + dp[i][0]);
            // System.out.println("G " + dp[i][1]);
            // System.out.println("B " + dp[i][2]);
        }

        System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
        br.close();
    }
}
