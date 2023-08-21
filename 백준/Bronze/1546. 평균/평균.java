import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 40, 60, 80
        Arrays.sort(arr);

        int max = arr[n - 1];
        double answer = 0;

        for (int j : arr) {
            // ※ 자바에서 정수 / 정수는 몫을 가져올 때, 정수 부분까지만 가져옴
            answer += ((double) j / max) * 100;
        }

        System.out.println(answer / n);

        br.close();
    }
}