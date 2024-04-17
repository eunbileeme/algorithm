import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0. 좌표가 될 정수형 2차원 배열
        int[][] board = new int[100][100];
        // 면적을 산출할 정수형 변수
        int area = 0;

        // 1. 테스트 케이스는 총 4개
        int testCase = 4;
        for (int i = 0; i < testCase; i++) {
            // 2. (한 줄 마다) 2개의 x / y 좌표를 받는다.
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 3. x1 ~ x2까지, y1 ~ y2까지 반복한다.
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    // 4. 해당 칸은 값을 1씩 누적한다. = 면적을 세기 위한 용도
                    board[j][k] = 1;
                }
            }
        }

        // 5. 1개의 개수를 셈으로써 넓이 산출
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) area++;
            }
        }

        // 6. 넓이 출력
        System.out.println(area);
        br.close();
    }
}
