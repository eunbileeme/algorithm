import java.io.*;
import java.util.*;

public class Main {
    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m]; // 체스판

        // ※ 주어진 체스판의 색을 arr에 담음
        for (int i = 0; i < n; i ++) {
            String s = br.readLine();
            for (int j = 0; j < m; j ++) {
                if (s.charAt(j) == 'W') // 열(= 가로)을 하나씩 조사하여 정의
                    arr[i][j] = true; // White = true
                else
                    arr[i][j] = false; // Black = false
            }
        }

        // ※ 8 x 8로 자를 때, 자를 수 있는 총 경우의 수
        int n_row = n - 7; // 행(= 세로)
        int m_col = m - 7; // 열(= 가로)

        // ※ 담은 색을 기반으로 옳게 칠해졌는지 조사 후 판단
        for (int i = 0; i < n_row; i ++) {
            for (int j = 0; j < m_col; j ++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    // ※ 주어진 체스판의 인덱스를 매개변수로 받아와서 옳게 칠해졌는지 조사
    private static void find(int x, int y) {
        int end_x = x + 8; // ※ 기준점(= 인덱스)으로부터 + 8
        int end_y = y + 8;
        int count = 0;

        boolean TF = arr[x][y]; // 첫 번째 칸의 색

        for (int i = x; i < end_x; i ++) {
            for (int j = y; j < end_y; j ++) {
                // 기댓값이 아닐 경우(= 올바른 색이 아닐 경우), count + 1
                if (arr[i][j] != TF) {
                    count ++;
                }

                /*
                * 다음 칸은 색이 바뀌므로
                * true라면 false로, false라면 true로
                * 값을 변경
                */
                TF = (!TF);
            }

            TF = !TF;
        }

        /*
        * 첫 번째 칸을 기준으로 할 때의 색칠할 개수(count)와
        * 첫 번째 칸의 색에 반대되는 색을 기준으로 할 때의 색칠할 개수(64 - count) 중
        * 최솟값을 count에 저장
         */
        count = Math.min(count, 64 - count);

        /*
        * 직전까지의 count값과 현재 count의 값 중
        * 더 작은 값을 최솟값으로 갱신
        */
        min = Math.min(min, count);
    }
}