import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 동전의 종류
        int k = Integer.parseInt(st.nextToken()); // 합

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int cnt = 0;
        for (int i = arr.length - 1; i >= 0; i --) { // ※ 나눴던 동전으로 반복해서 나누는 일이 없으므로 2중 loop문을 구성할 필요가 없음
            if (arr[i] <= k) {
                cnt += (k / arr[i]);
                k = (k % arr[i]);
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
