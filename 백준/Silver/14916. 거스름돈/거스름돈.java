// 그리디
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        // ※ 5로 나눌 수 있을 때까지 나누는 것에 집착하여 실패
        // (1) 5로 나눌 수 있다면 -> 5로 나눈 값의 몫 = 동전의 개수
        // (2) 5로 나눌 수 없다면 -> 2로 뺀 후 다시 비교
        while(true) {
            if (n % 5 == 0) {
                cnt += n / 5;
                break;
            }
            n -= 2;
            cnt ++;
        }

        if (n < 0) {
            bw.write(-1 + "");
            bw.flush();
        } else {
            bw.write(cnt + "");
            bw.flush();
        }

        bw.close();
        br.close();
    }
}