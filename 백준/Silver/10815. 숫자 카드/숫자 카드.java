import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// ※ O(10,000,000) -> O(n) ~ O(1) -> get, add, remove가 O(1)인 Map을 사용
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. 입력 및 출력
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            map.put(st.nextToken(), 0);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        // 2. 로직
        for (int i = 0; i < m; i ++) {
            if (map.get(st.nextToken()) != null) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        // 3. 출력
        System.out.println(sb);
        br.close();
    }
}
