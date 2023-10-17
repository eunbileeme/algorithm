import java.io.*;

// 최소값 -> 음수값이 커야 -> 최대한 큰 수를 빼주어야 => 덧셈 부분을 먼저 계산해야 = "뺄셈을 기준으로 분리"
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // ※ 수는 5자리를 초과할 수 없으며, 연속으로 tmp에 같은 값이 들어올 수 있으므로
        // 중간 계산 결과값으로 나올 수 있는 0이 아닌 값으로 초기화
        int sum = Integer.MAX_VALUE;
        String[] sub = br.readLine().split("-"); // [30, 70, 20+40, 10+100+30, 35]

        for (int i = 0; i < sub.length; i++) {
            int tmp = 0;

            // ※ +의 경우, 정규식이 아닌 메타 문자이므로
            // 문자 그 자체를 표현하기 위해 이스케이프 처리(\\) 진행
            String[] add = sub[i].split("\\+"); // i = 0, [30] -> i = 1, [70], i = 2 -> [20, 40], ..

            for (int j = 0; j < add.length; j++) {
                tmp += Integer.parseInt(add[j]); // j = 0, + 20 -> j = 1, + 20 + 40
            }

            if (sum == Integer.MAX_VALUE) sum = tmp;
            else sum -= tmp;
        }

        System.out.println(sum);
    }
}