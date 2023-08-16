// 그리디 : https://subin-programming.tistory.com/232
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

        // 5 또는 2원으로 나눠줄 수 없는 경우에도, while문은 항상 true임으로 내부의 로직을 수행
        // 따라서 5 또는 2원으로 나눠줄 수 없다면, 수중의 돈이 음수인 상황일 것
        if (n < 0) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }

        br.close();
    }
}
