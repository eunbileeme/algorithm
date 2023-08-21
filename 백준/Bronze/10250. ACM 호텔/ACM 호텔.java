import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // ※ n = 1, h = 1, w = 12, person = 2
        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int person = Integer.parseInt(st.nextToken());

            // ※ -1을 하는 이유 : 0-based 인덱싱
            // 즉, 프로그래밍에서 첫 번째는 0에 해당하기 때문에 -1을 수행
            
            // ※ 몫 연산 : 그 층에서 몇 번째 방에 위치해야 하는지
            int width = (person - 1) / h + 1;
            // ※ 나머지 연산 : 손님이 어떤 층에 위치해야 하는지
            int height = (person - 1) % h + 1;

            System.out.println(height * 100 + width);
        }

        br.close();
    }
}