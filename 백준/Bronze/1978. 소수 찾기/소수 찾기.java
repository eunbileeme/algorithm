// https://st-lab.tistory.com/80
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int cnt = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i ++) {
            boolean isPrime = true;
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 1)
                continue;
            // ※ 소수 판별
            // arr[i]가 2부터 Math.sqrt(arr[i])까지의 어떤 수로도 나누어 떨어지지 않아야 함
            // 따라서, isPrime 변수를 통해 한 번이라도 나누어 떨어지면 isPrime = false로 설정
            // 모든 j에 대해서 나누어 떨어지지 않으면 cnt ++
            for (int j = 2; j <= Math.sqrt(arr[i]); j ++) {
                if (arr[i] % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                cnt ++;
            }
        }

        System.out.println(cnt);

        br.close();
    }
}