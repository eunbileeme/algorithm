import java.io.*;
import java.util.*;

// TODO 1. 1 ~ 7까지 자연수 중에서 중복 없이 m개를 고른 수열
// TODO 2. 중복되는 수열을 여러 번 출력하면 안되며 -> ex. (1, 2) / (1, 2) (x)
// TODO 3. 각 수열은 공백으로 구분해서 출력 -> sb.append(" ");
// TODO 4. 수열은 사전 순으로 증가하는 순서로 출력 -> Arrays.sort();
// TODO 5. (1, 2) <-> (2, 1) = 순열
public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            numbers[i] = i;
        }

//        for (int number : numbers) {
//            System.out.println(number);
//        }

        boolean[] visited = new boolean[n + 1]; // n + 1?
        int[] tempResult = new int[m];
        permutation(numbers, visited, tempResult, 0);
        br.close();
    }

    private static void permutation(int[] numbers, boolean[] visited, int[] tempResult, int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();

            for (int temp : tempResult) {
                sb.append(temp).append(" ");
            }

            System.out.println(sb);
            return; // 아무 생각 없이 break; 적지 말기
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tempResult[depth] = numbers[i];

                permutation(numbers, visited, tempResult, depth + 1);
                visited[i] = false;
            }
        }
    }
}
