import java.io.*;
import java.util.*;

public class Main {
    // TODO : 덩치 = x + y
    // ex. A (56, 177) / B (45, 165) = 56 > 45, 177 > 165 => A > B
    // ex. C (45, 181) / (55, 173) = 45 < 55, 181 > 173 => 규정 x

    // TODO x, y를 모두 비교해야 함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 1. 입력
        int[][] size = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < 2; j++) {
                size[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for (int[] ints : size) {
//            System.out.println(Arrays.toString(ints));
//        }

//        int[][] copySize = Arrays.copyOf(size, size.length);
//        Arrays.sort(copySize, (x, y) -> Integer.compare(y[0], x[0]));

        // 2. x, y 비교
        // TODO 첫 번째 값(ex. size[0][0])을 기준으로 두 번째, 세 번째, .. , 다섯 번째 값과 행열을 비교해야 함
        // 이때, 2중 for문을 행열이 아닌 행간의 이동으로 보면 어떨까??
        for (int i = 0; i < n; i++) {
            // 덩치 등수는 k + 1부터..
            int rank = 1;

            for (int j = 0; j < n; j++) {
                // 자기 자신과의 값 비교는 제외
                if (i == j) continue;

                if (size[i][0] < size[j][0] && size[i][1] < size[j][1]) {
                    rank++;
                }
            }

            sb.append(rank + " ");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

        br.close();
    }
}
