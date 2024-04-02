import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int aRow = Integer.parseInt(st.nextToken());
        int aCol = Integer.parseInt(st.nextToken());

        // 1. 행렬 A 입력
        int[][] a = new int[aRow][aCol];
        for (int i = 0; i < aRow; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < aCol; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 행렬 B 입력
        st = new StringTokenizer(br.readLine(), " ");
        int bRow = Integer.parseInt(st.nextToken());
        int bCol = Integer.parseInt(st.nextToken());

        int[][] b = new int[bRow][bCol];
        for (int i = 0; i < bRow; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < bCol; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 출력용 행렬
        int[][] nK = new int[aRow][bCol];

        // 3.
        for (int i = 0; i < aRow; i++) {
            for (int j = 0; j < bCol; j++) {
                for (int l = 0; l < aCol; l++) {
                    nK[i][j] += a[i][l] * b[l][j];
                }
            }
        }

        // 4. 출력
        for (int i = 0; i < aRow; i++) {
            for (int j = 0; j < bCol; j++) {
                System.out.print(nK[i][j] + " ");
            }
            System.out.println();
        }
        br.close();
    }
}
