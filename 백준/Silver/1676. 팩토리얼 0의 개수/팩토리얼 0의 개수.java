import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        // ※ 답이 5의 개수에 따라 좌지우지되므로 n은 5보다 크거나 같을 때까지만 반복하면 됨
        while (n >= 5) {
            cnt += n / 5;
            n /= 5;
        }

        System.out.println(cnt);

        br.close();
    }
}