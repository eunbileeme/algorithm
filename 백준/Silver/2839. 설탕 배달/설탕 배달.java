// 그리디 : 배달할 봉지의 최소 개수
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (n > 0) {
            // ※ 더 큰 수의 배수라면, 몫을 담은 후 바로 탈출
            if (n % 5 == 0) {
                cnt += n / 5;
                break;
            }
            // ※ 아닐 경우에는 더 작은 수를 빼면서 진행
            n -= 3;
            cnt ++;
        }

        if (n < 0)
            System.out.println(-1);
        else
            System.out.println(cnt);

        br.close();
    }
}