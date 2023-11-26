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

    /*
    * B[k] 구하기
    * = 특정값 찾기
    *
    * lower bound(= 하한 값) : 찾고자 하는 값 이상의 값이 처음으로 나타나는 위치
    * <-> upper bound가 아닌 이유로는 구하고자 한 B[k]를 처음으로 초과하는 위치가 upper bound인데..
    * 이럴 경우, 찾고자 하는 값 자체를 못 찾기 때문에 아님
    *
    * m (구하고자 하는 값) : 값 <-> 인덱스
    */

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

            if (target <= cnt) {
                result = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return result;
    }
}
