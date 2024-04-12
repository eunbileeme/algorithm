import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    // static int bingGo = 0;
    static int bingGoNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 빙고판 입력
        board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 사회자가 수를 부른다.
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                int call = Integer.parseInt(st.nextToken());
                // TODO 매번 모든 칸을 순회하면서 체크하므로, 빙고는 매번 카운트를 진행해야
                int bingGo = 0;

                // 2-1. 사회자가 부른 수가 빙고판에 있다면
                bingGo = find(call, bingGo);

                // 2-8. 빙고가 3 이상이라면
                // TODO 3 이상인 이유 : 체킹한 원소가 한 번에 투 빙고를 완성할 수도 있기 때문
                if (bingGo >= 3) {
                    System.out.println(bingGoNum);
                    return;
                }
            }
        }
    }

    private static int find(int call, int bingGo) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == 0) continue;

                if (board[i][j] == call) {
                    // 2-2. 지운다.
                    board[i][j] = 0;
                    bingGoNum++;

                    // 2-3. 가로 / 세로 / 대각선(우하향, 우상향)을 순회하면서
                    // 5개의 수가 모두 0이 된 가로 / 세로 / 대각선이 있는지 탐색한다.
                    bingGo = check(bingGo);
                }
            }
        }

        return bingGo;
    }

    private static int check(int bingGo) {
        bingGo = checkRowAndCol(bingGo);
        bingGo = checkDiagnal(bingGo);

        return bingGo;
    }

    private static int checkRowAndCol(int bingGo) {
        // 2-4. 행을 순회한다.
        for (int i = 0; i < 5; i++) {
            // 2-5. 한 행마다 0의 개수를 셀 변수
            int rowCnt = 0;
            int colCnt = 0;
            for (int j = 0; j < 5; j++) {
                // 2-6. 해당 수가 0이라면, cnt ++;
                if (board[i][j] == 0) rowCnt++;
                if (board[j][i] == 0) colCnt++;
                // 2-7. cnt가 5라면 빙고
                if (rowCnt == 5) bingGo++;
                if (colCnt == 5) bingGo++;
            }
        }

        return bingGo;
    }

    private static int checkDiagnal(int bingGo) {
        int upCnt = 0;
        int downCnt = 0;

        for (int i = 0; i < 5; i++) {
            if (board[i][i] == 0) upCnt++;
            if (board[i][4 - i] == 0) downCnt++;

            if (upCnt == 5) bingGo++;
            if (downCnt == 5) bingGo++;
        }

        return bingGo;
    }
}
