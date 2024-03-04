import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO 1. "행렬을 제곱했다." -> "행렬 A * 행렬 A" -> (n * n) * (n * n)
// 행렬 A = m(행) * k(열), 행렬 B = k(행) * n(열) = m * n

// ex. A = {a11, a12, a13,    B = {b11, b12
//          a21, a22, a23}         b21, b22
//                                 b31, b32}
// A * B = {a11b11 + a12b21 + a13b31 + a11b12 + a12b22 + a13b32
//          a21b11 + a22b21 + a23b31 + a21b12 + a22b22 + a23b32}
// TODO 2. 100,000,000,000 (1,000억) -> int형의 범위(= 21억) 를 넘어가므로 B는 long 타입으로 선언

// ex. A = {1, 2, 3, 4}, B = 5
// A = {1, 2     A = {1, 2
//      3, 4}         3, 4}
// A^2 = (A^2) * (A^2) * A
//     = A * A * A * A * A
public class Main {
    static int n;
    static int[][] board;
    static int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                // if) 행렬 A의 원소가 1000, B = 1일 경우, (1000^1) % 1000이므로 A의 기댓값은 0이 되어야한다.
                // 하지만, 거듭 제곱시 지수가 1이라면 1000을 나누지 않고 그대로 값을 도출해버리므로 A의 결과값은 1000이 된다.
                // 따라서, 이 현상을 방지해주기 위해 "결과값을 구한 후 나누는 것"이 아니라 "결과값을 구하기 전, 입력값을 할당받은 직후 미리 1000을 나누는 것"
                board[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

//        for (int[] ints : board) {
//            System.out.println(Arrays.toString(ints));
//        }

        // TODO 복기 부분 디버깅 해보기 (값이 다르게 나옴)
        StringBuilder sb = new StringBuilder();
        int[][] answer = pow(board, b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(answer[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int[][] pow(int[][] board, long b) {
        if (b == 1L) { // long은 끝에 L을 붙이는, 즉 리터럴 방식으로 서술해야 함
            return board;
        }

        int[][] lowMatrix = pow(board, b / 2);

        lowMatrix = lowPow(lowMatrix, lowMatrix);
        if (b % 2 == 1L) {
            lowMatrix = lowPow(lowMatrix, board); // TODO 복기 요망
        }

        return lowMatrix;
    }

    private static int[][] lowPow(int[][] a, int[][] anotherA) {
        int[][] lowMatrix = new int[n][n];

        for (int i = 0; i < n; i++) { // ex. 행렬 A의 행
            for (int j = 0; j < n; j++) { // 행렬 B의 열
                for (int k = 0; k < n; k++) { // TODO 행렬 A의 열 = 행렬 B의 행, 복기 요망
                    lowMatrix[i][j] += a[i][k] * anotherA[k][j];
                    lowMatrix[i][j] %= MOD;
                }
            }
        }

        return lowMatrix;
    }
}
