import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// ※ HashMap<문자열, 번호> 또는 HashMap<번호, 문자열>
// ※ O(100,000) -> O(n^2) ~ O(nlogn)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> strGuide = new HashMap<>();
        HashMap<Integer, String> intGuide = new HashMap<>();

        for (int i = 1; i <= n; i ++) {
            String name = br.readLine();
            strGuide.put(name, i);
            intGuide.put(i, name);
        }

        for (int i = 0; i < m; i ++) {
            String name = br.readLine();
            if (49 <= name.charAt(0) && name.charAt(0) <= 57) {
                sb.append(intGuide.get(Integer.parseInt(name))).append("\n");
            } else {
                sb.append(strGuide.get(name)).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
