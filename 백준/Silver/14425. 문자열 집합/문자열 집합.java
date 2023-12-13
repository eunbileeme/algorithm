import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// ※ 문자열이 포함되어 있는지 아닌지 -> Map<문자열, 빈도수>
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입출력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int includeStringNum = Integer.parseInt(st.nextToken());
        int checkStringNum = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();

        // 2.
        for (int i = 0; i < includeStringNum; i++) {
            map.put(br.readLine(), 0);
        }

        // 3. 로직
        int cnt = 0;
        for (int i = 0; i < checkStringNum; i++) {
            if (map.containsKey(br.readLine())) {
                cnt++;
            }
        }

        // 4. 출력
        System.out.println(cnt);
        br.close();
    }
}
