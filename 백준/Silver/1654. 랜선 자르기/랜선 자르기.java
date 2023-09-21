import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        System.out.println(getValue(arr, k));

        br.close();
    }

    private static long getValue(int[] arr, int targetCnt) {
        long l = 1; // ※ 랜선 길이가 0이 되지 않도록 1로 초기화
        long r = arr[arr.length - 1];
        long maxLength = 0;

        while (l <= r) {
            long m = l + (r - l) / 2;
            int cnt = 0;

            for (int i = 0; i < arr.length; i ++) {
                cnt += (arr[i] / m);
            }

            if (cnt < targetCnt) {
                r = m - 1;
            } else {
                maxLength = m;
                l = m + 1;
            }
        }

        return maxLength;
    }
}