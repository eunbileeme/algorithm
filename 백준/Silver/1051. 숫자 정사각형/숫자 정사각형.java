import java.io.*;
import java.util.*;

public class Main {
    // 꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형 찾기
    // output : 정답 정사각형의 크기

    // TODO 정사각형의 크기란? : 넓이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 1. 직사각형 입력
        int[][] board = new int[n][m]; // 행 열
        for (int i = 0; i < n; i ++) {
            String row = br.readLine(); // Q. StringTokenizer로 받았을 경우, 왜 Integer.valueOf()나 - '0'으로 board[i][j]를 받을 수 없는가?
            for (int j = 0; j < m; j ++) {
                board[i][j] = row.charAt(j) - '0';
            }
        }

//        for (int[] ints : board) {
//            System.out.println(Arrays.toString(ints));
//        }

        // 2. 왼쪽 위 꼭짓점, 오른쪽 위 꼭짓점, 왼쪽 아래 꼭짓점 , 오른쪽 아래 꼭짓점

        // 아이디어 1.
        // - 한 행을 받았을 때, i 및 i + 1로 접근
        // - 열을 받았을 때, j 및 j + 1로 접근
        // TODO 근데, 한 번의 행에 열을 기준으로 0 1 / 1 0 / 2 0 .. 처럼 반복할 수 있도록 어떻게 구현해야할지를 잘 모르겠음

        // 아이디어 2.
        // - 최댓값을 구하는 거니까, 오히려 길이를 줄여서 정사각형을 보는건 어떨까?
        // - 내지는 가로 or 세로의 길이 중 더 작은 길이에 맞춰?

        // TODO (1) 가로 or 세로 길이 중 큰건 어떻게 판단할까?
        int maxLen = Math.min(n, m);

        // TODO (2) 1x1, 2x2, .. 등 정사각형의 각 꼭짓점을 어떻게 탐색할까?
        while (maxLen > 1) {
            for (int i = 0; i <= n - maxLen; i ++) {
                for (int j = 0; j <= m - maxLen; j ++) {
                    // TODO a. 기준점
                    int point = board[i][j];

                    // TODO b. 꼭짓점 탐색
                    // ex. (1 [0][0], 2 [0][1])
                    //     (3 [1][0], 4 [1][1])
                    // point = 1[0][0], board[i][j + maxLen - 1] = 2[0][1]
                    // point = 1, board[i + maxLen - 1][j] = 3[1][0]
                    // point = 1, board[i + maxLen - 1][j + maxLne - 1] = 4[1][1]
                    if (point == board[i][j + maxLen - 1] && point == board[i + maxLen - 1][j] && point == board[i + maxLen - 1][j + maxLen - 1]) {
                        System.out.println(maxLen * maxLen);
                        return;
                    }
                }
            }

            maxLen --;
        }

        System.out.println(maxLen * maxLen);
        br.close();
    }
}
