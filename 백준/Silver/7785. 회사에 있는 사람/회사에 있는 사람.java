import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

// ※ O(1,000,000) -> o(n log n)
// ※ Map<사람 이름, 현재 상태>
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입출력
        int person = Integer.parseInt(br.readLine());
        HashMap<String, String> map = new HashMap<>();

        // 2. 로직
        for (int i = 0; i < person; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String state = st.nextToken();

            // ※ 그냥 넣지 말고, 이미 있는지 없는지 확인해야 함
            // ※ 또한, map.value.equals("enter")도 좋지만, key(= name)가 이미 있는지 없는지를 통해 간단하게 퇴근 여부 판별 가능
            if (map.containsKey(name)) {
                map.remove(name);
            } else {
                map.put(name, state);
            }
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, Collections.reverseOrder());

        // 3. 출력
        for (String name : list) {
            System.out.println(name);
        }
        br.close();
    }
}
