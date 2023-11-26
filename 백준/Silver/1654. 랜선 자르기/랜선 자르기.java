import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 1. 초기화
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] cables = new int[k];

        // 2. 입력
        for (int i = 0; i < cables.length; i++) {
            cables[i] = Integer.parseInt(br.readLine());
        }

        // 3. 정렬
        Arrays.sort(cables);

        // 4. 출력
        System.out.println(getMaxCableLength(cables, n));
        br.close();
    }

    /*
    * 만들 수 있는 랜선의 최대 길이 구하기
    * lower bound(= 하한 값) : 찾고자 하는 값 이상의 값이 처음으로 나타나는 위치
    * = lower bound로 찾고자 하는 값을 기준으로 점진적으로 증가시켜나가면서 최댓값 찾기
    * m (구하고자 하는 값) : 랜선 길이(값) <-> 인덱스
     */

    private static long getMaxCableLength(int[] cables, int target) {
        long l = 1;
        long r = cables[cables.length - 1];
        long maxLength = 0;

        while (l <= r) {
            long m = l + (r - l) / 2;
            int cableCnt = 0;

            for (int i = 0; i < cables.length; i++) {
                cableCnt += (cables[i] / m);
            }
            
            if (target <= cableCnt) {
                // 목표 개수가 자른 케이블의 개수보다 작다면
                // 랜선을 작게 작게 잘랐다는 것 = 자를 랜선의 길이를 늘려야 함
                maxLength = m;
                l = m + 1;
            } else {
                r = m - 1; // target > cableCnt
            }
        }

        return maxLength;
    }
}
