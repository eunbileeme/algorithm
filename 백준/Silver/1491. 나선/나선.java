import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 6, 열
        int m = Integer.parseInt(st.nextToken()); // 4, 행

        // 1. 행 순회(= 하나의 행에서 여러 열 원소 순회), 열 순회(= 하나의 열에서 여러 행 원소 순회)시 짝을 맞춰서 순회
        // 이때, 순회하는 횟수가 Math.min()과 동일하다.
        // ex. N = 6, M = 4 -> 행 순회 4번 = 행의 개수, 열 순회 4번(단, 이 경우는 나선이 끝나는 곳의 위치도 포함) = 행의 개수
        int num = Math.min(m, n);
        int row = 0;
        int col = 0;

        // 2. 행/열씩 짝지어서 순회하므로 Math.min() * 2
        for (int i = 0; i < num * 2; i++) {
            if (i == 0) {
                col = n - 1; // row, i = 0
            }
            if (i != 0 && i % 4 == 0) {
                col += --n; // row, i = 4
            } else if (i % 4 == 1) {
                row += --m; // col, i = 1, 5
            } else if (i % 4 == 2) {
                col -= --n; // row, i = 2, 6
            } else if (i % 4 == 3) {
                // TODO 단, i = 7일 때 이미 m이 0이므로 row 값에 변동이 없음
                row -= --m; // col, i = 3, 7
            }
        }
        
        // 3. 출력
        System.out.printf("%d %d", col, row);
        br.close();
    }
}
