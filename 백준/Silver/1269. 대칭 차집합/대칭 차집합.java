import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// ※ O(200,000) -> O(n^2) ~ O(nlogn)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int setANum = Integer.parseInt(st.nextToken());
        int setBNum = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < setANum; i ++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < setBNum; i ++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        for (int num : setA) {
            if (!setB.contains(num)) {
                result += 1;
            }
        }

        for (int num : setB) {
            if (!setA.contains(num)) {
                result += 1;
            }
        }

        System.out.println(result);
        br.close();
    }
}
