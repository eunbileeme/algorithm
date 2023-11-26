import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 변수 초기화
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        // 2. 탐색 및 출력
        System.out.println(binarySearch(n, k));
        br.close();
    }

    private static long binarySearch(int n, int target) {
        long l = 1;
        long r = target;
        long result = 0;

        while (l <= r) {
            long m = l + (r - l) / 2;
            long cnt = 0;

            for (int i = 1; i <= n; i++) {
                cnt += Math.min(m / i, n);
            }
            
            if (target <= cnt) { // 작거나 같은 -> 조건을 만족하는 값들 중에 가장 최댓값
                result = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return result;
    }
}
