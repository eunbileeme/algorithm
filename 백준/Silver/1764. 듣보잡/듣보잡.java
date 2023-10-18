import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()); // 듣도 못한 사람의 수 : n
        int m = Integer.parseInt(st.nextToken()); // 보도 못한 사람의 수 : m

        // ※ 중복이 있을 수도 있으므로 HashSet
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i ++) {
            set.add(br.readLine());
        }

        // ※ 보도 못한 사람의 이름을 입력받을 때,
        // 듣도 못한 사람들 중 동일한 이름이라면 추가
        ArrayList<String> result = new ArrayList<>();
        for (int i = n; i < m + n; i ++) {
            String str = br.readLine();
            if (set.contains(str)) {
                result.add(str);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}