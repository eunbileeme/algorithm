import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 0.
        Map<String, ArrayList<Integer>> map = new HashMap<>();

        // 1.
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // ex. Mickey 1 10 1991
            // 2. Map<String, ArrayList>> : 이름 - 년도, 월, 일 순으로 저장
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            // 2-1. 주어진 순서대로 일, 월, 년도 순으로 저장
            ArrayList<Integer> birthday = new ArrayList<>(Arrays.asList(year, month, day));
            map.put(name, birthday);

            // 2-2. Collections.reverseOrder()
        }

        // 3. 년도 -> 일 -> 월 순으로 비교
        Comparator<Map.Entry<String, ArrayList<Integer>>> comparator = (a, b) -> {
            ArrayList<Integer> date1 = a.getValue();
            ArrayList<Integer> date2 = b.getValue();

            if (!date1.get(0).equals(date2.get(0))) {
                return date1.get(0) - date2.get(0);
            } else if (!date1.get(1).equals(date2.get(1))) {
                return date1.get(1) - date2.get(1);
            } else {
                return date1.get(2) - date2.get(2);
            }
        };

        // 4. value 기준, 가장 나이가 적은 사람 / 가장 나이가 많은 사람
        // key 기준, 이름을 가져와서 출력
        // System.out.println("map.entrySet() = " + map.entrySet());
        String young = Collections.max(map.entrySet(), comparator).getKey(); // 어리다 -> 값이 크다 -> amx
        // System.out.println(Collections.max(map.entrySet(), comparator));
        String old = Collections.min(map.entrySet(), comparator).getKey();
        // System.out.println(Collections.min(map.entrySet(), comparator));

        System.out.println(young);
        System.out.println(old);

        br.close();
    }
}
