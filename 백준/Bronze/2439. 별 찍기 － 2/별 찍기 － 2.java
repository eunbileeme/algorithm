import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        // ※ 하나의 큰 for문안에서 두 for문으로 공백과 *을 (*개행을 하지 않았으므로*) 연결해서 출력
        // 이후, 줄이 바뀔 때마다 개행
        for (int i = 1; i <= a; i ++) {
            // ※ i번째 줄마다 a - i개씩 공백이 줄어들어야 함
            for (int j = 1; j <= a - i; j ++) {
                sb.append(' ');
            }
            for (int k = 1; k <= i; k ++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        System.out.println(sb);

        br.close();
    }
}