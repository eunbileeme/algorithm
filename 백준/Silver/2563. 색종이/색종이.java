import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1. 넓이 및 색종이 색칠 여부를 위한 boolean 배열
        int area = 0;
        boolean[][] paper = new boolean[100][100];

        // 2. 색종이를 붙인 위치를 기준으로 넓이 산출
        // ex. 3 7 -> x좌표 상으로 3부터 13까지, y좌표 상으로 7부터 17까지
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()); // 열
            int y = Integer.parseInt(st.nextToken()); // 행

            // 3. 도화지 탐색
            for (int j = x; j <= x + 9; j++) {
                for (int k = y; k <= y + 9; k++) {
                    if (!paper[j][k]) {
                        paper[j][k] = true;

                        area++;
                    }
                }
            }
        }

        // 3. 출력
        System.out.println(area);
        br.close();
    }
}
