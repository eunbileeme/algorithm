import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // ※ 마지막 날을 제외하고 V−A 만큼의 거리를 A−B의 속도로 올라가야 함
        // 마지막 날에는 달팽이가 A만큼 올라가면 미끄러지지 않기 때문
        // 따라서 V-A 만큼 A-B의 속도로 올라간 후, A만큼 한 번만 이동하면 나무 막대를 모두 올라간 것
        int days = (V - A) / (A - B) + 1;
        if ((V - A) % (A - B) != 0) {
            days++;
        }

        System.out.println(days);
    }
}
