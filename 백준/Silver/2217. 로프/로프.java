// 그리디
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rope = new int[n];

        for (int i = 0; i < n; i ++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope);

        int max = rope[n - 1];
        // 로프의 개수를 하나씩 추가해나가면서 그 순간에 최대 중량을 들 수 있는 로프보다 더 들 수 있는지 체크
        for (int i = 0; i < n; i ++) {
            max = Math.max(max, rope[i] * (n - i));
        }

        System.out.println(max);

        br.close();
    }
}