import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st1.nextToken());
        int x = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i ++) {
            // ※ st2.nextToken() : 한 번 호출할 때마다, 토큰을 사용
            // 따라서 st2.nextToken으로 가리키고자 하는 값은 변수에 담아서 사용
            int value = Integer.parseInt(st2.nextToken());
            if (x > value) {
                System.out.print(value + " ");
            }
        }

        br.close();
    }
}