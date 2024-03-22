import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 1. 배수를 체크하기 위한 boolean 배열 선언 및 초기화
        boolean[] multiples = new boolean[n + 1];

        // 2. k번째인지 아닌지 판별할 변수 선언 및 초기화
        int cnt = 0;

        // 3. 2부터 N까지 순회
        for (int i = 2; i <= n; i++) {
            // 4. 배수
            // TODO j의 범위는?
            for (int j = i; j <= n; j += i) {
                // ex. (7, 3)
                // 2 3 4 5 6 7
                // j = 2,

                // TODO 5. 아직 체크하지 않은 P(= i)의 배수라면
                if (!multiples[j]) {
                    multiples[j] = true;
                    cnt++;

                    // 6. k번째라면
                    if (cnt == k) {
                        System.out.println(j);
                        // TODO 함수 종료.
                        return;
                    }
                }
            }
        }

        br.close();
    }
}
