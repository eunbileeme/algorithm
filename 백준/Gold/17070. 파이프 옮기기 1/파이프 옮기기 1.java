import java.io.*;
import java.util.*;

// TODO 파이프의 한쪽 끝을 (N, N)로 이동시키는 방법의 개수
// TODO 1. 파이프를 밀 수 있는 방향은 총 3가지 (오른쪽, 오른쪽 아래 대각선, 아래) -> (i, j + 1) / (i - 1, j + 1) / (i, j + 1)
// TODO 2. 처음 파이프의 위치는 (1, 1) 및 (1, 2)

// TODO 어떻게 예제 입력 1의 답이 1이지? -> 파이프의 이동 횟수가 아닌 이동시킬 수 있는 방법의 개수이기 때문
// TODO 파이프가 가로 상태일 경우는 가로 또는 오른쪽 아래 대각선의 형태로만 붙일 수 있음 -> 맨 처음의 파이프에 이어붙일 수 있는 다음 경우의 수는 가로 또는 오른쪽 아래 대각선의 형태뿐
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            // TODO 공백 잘 체크하기
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        // TODO 1. 가로 / 세로 / 대각선 상태에 어떻게 접근할 수 있을까? -> 각각의 상태를 저장해서 구분
        // TODO 2. 이동 횟수가 아닌 이동시킬 수 있는 경우의 수 -> DFS
        // TODO 3. 또한, 이전 파이프의 상태에 따라 가로 / 세로 / 대각선으로 이동할 수 있는 경우의 수가 달라짐
        // TODO Q. 근데, DP로 풀이할 경우 - DP의 정의인 "이전까지의 최적의 해" + 현재 값의 구성으로 풀이되지가 않는데..

        int[][][] dp = new int[n][n][3];
        dp[0][1][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 2; j < n; j++) {
                if (j - 1 >= 0 && board[i][j] == 0) {
                    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                }

                if (i - 1 >= 0 && board[i][j] == 0) {
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                }

                if (i - 1 >= 0 && j - 1 >= 0 && board[i][j] == 0 && board[i - 1][j] == 0 && board[i][j - 1] == 0) {
                    dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }

        int result = dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2];
        System.out.println(result);
        br.close();
    }
}
