import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // TODO 0. 자릿수, 자릿수에 더할 값, 10의 제곱(10 -> 100 -> 1,000 -> ..)인지 아닌지 판단할 변수 선언 및 초기화
        // num : 10의 제곱이 될 때마다, (1) 자릿수에 더할 값 업데이트, (2) 다음으로 업데이트
        // 위 2개의 과정을 수행함으로써, 십의 자리 / 백의 자리 / ..가 될 때마다 정상적으로 2자리 / 3자리 / .. 를 더할 수 있게 됨.
        int cnt = 0;
        int plus = 1;
        int num = 10;

        // 1. 1 ~ n까지 순회
        for (int i = 1; i <= n; i++) {
            // TODO 2. 10의 제곱이면
            if (i % num == 0) {
                // TODO 3. 수에 더할 값 증가
                plus++;
                // TODO 4. 다음 10의 제곱으로 기준 업데이트
                num *= 10;
            }

            // TODO 5. 자릿수 누적
            cnt += plus;
        }

        // 6. 출력
        System.out.println(cnt);
        br.close();
    }
}
