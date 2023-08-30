import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i ++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(getResidents(k, n));
        }

        br.close();
    }

    public static int getResidents(int k, int n) {
        // ※ 메개변수로 넘겨줌으로써 k + 1, n + 1씩 배열 크기를 생성
        int[][] apartment = new int[k + 1][n + 1];

        // 0층 초기화
        // ※ 0층이 존재하며 i호는 i명이 살고있으므로 1 <= i <= n로 범위를 설정
        // 이때, 0층은 행 i호는 열
        for (int i = 1; i <= n; i ++) {
            apartment[0][i] = i;
        }

        // ※ 1층부터 n호에는 몇 명이 사는지 값을 구하고, k층을 향해 올라감
        for (int i = 1; i <= k; i ++) {
            for (int j = 1; j <= n; j ++) {
                // apartment[1][1] = apartment[1][0] + apartment[0][1] -> 0 + 1
                // ※ 이때, apartment[1][0]는 기본 초기화 값인 0으로 처리
                apartment[i][j] = apartment[i][j - 1] + apartment[i - 1][j];
            }
        }

        return apartment[k][n];
    }
}