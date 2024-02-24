import java.io.*;
import java.util.*;

// TODO 1. 최대 점수(위치한 곳의 수의 합), 최소 점수를 구하기
// TODO 2. 바로 아래의 수로 넘어가거나(= i + 1, j) 또는 바로 아래의 수와 붙어 있는 수(= i + 1, j - 1) 또는 (= i + 1, j + 1)로만 이동 가능

// TODO 해당 행에서 가장 작은 or 큰 값이 최소 or 최댓값을 가진다는 보장은 없음
//  -> 따라서 바로 다음 행의 수 or 그 수와 붙어있는 수들로 골랐을 때의 합이 작은지 판단해야 할 것 같은데..

public class Main {
    static int min, max = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] board = new int[n + 1][3]; // ex. 4 -> 0, 1, 2, 3
        for (int i = 0; i < n; i++) { // 0을 위가 아니라 아래에 붙이고 싶은데 -> 1, 2, 3
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. i, j -> (i - 1, j) /  (i - 1, j + 1)
        // 2. i, j -> (i - 1, j - 1) / (i - 1, j) / (i - 1, j + 1)
        // 3. i, j -> (i - 1, j - 1) / (i - 1, j)
        int[][] maxDp = new int[n + 1][3];
        int[][] minDp = new int[n + 1][3];

        getScore_dope(board, maxDp, minDp);
        System.out.println(max + " " + min);

        br.close();
    }

    private static void getScore_dope(int[][] board, int[][] maxDp, int[][] minDp) {
        for (int i = 0; i < 3; i++) {
            maxDp[0][i] = board[0][i];
            minDp[0][i] = board[0][i];
        }

        for (int i = 1; i < n; i++) {
            maxDp[i][0] = board[i][0] + Math.max(maxDp[i - 1][0], maxDp[i - 1][1]);
            maxDp[i][1] = board[i][1] + Math.max(maxDp[i - 1][0], Math.max(maxDp[i - 1][1], maxDp[i - 1][2]));
            maxDp[i][2] = board[i][2] + Math.max(maxDp[i - 1][1], maxDp[i - 1][2]);

            minDp[i][0] = board[i][0] + Math.min(minDp[i - 1][0], minDp[i - 1][1]);
            minDp[i][1] = board[i][1] + Math.min(minDp[i - 1][0], Math.min(minDp[i - 1][1], minDp[i - 1][2]));
            minDp[i][2] = board[i][2] + Math.min(minDp[i - 1][1], minDp[i - 1][2]);
        }

        max = Math.max(maxDp[n - 1][0], Math.max(maxDp[n - 1][1], maxDp[n - 1][2]));
        min = Math.min(minDp[n - 1][0], Math.min(minDp[n - 1][1], minDp[n - 1][2]));
    }
}