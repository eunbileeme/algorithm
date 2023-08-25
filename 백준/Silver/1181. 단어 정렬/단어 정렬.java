import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            list.add(br.readLine());
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // ※ 두 문자열(o1, o2)의 길이의 차를 변수에 저장
                // (1) o1의 길이가 o2의 길이보다 짧다면 len = -1
                // (2) o1의 길이가 o2와 같다면 len = 0
                // (3) o1의 길이가 o2보다 길다면 len = 1
                int len = Integer.compare(o1.length(), o2.length());

                if (len == 0) {
                    // (1) o1이 사전 순으로 앞에 있으면 -1 -> Collections.sort()는 o1를 o2 앞에 위치시킴
                    // (2) o1가 사전 순으로 동일하면 0 (이 경우, 순서에 변화는 없음)
                    // (3) o1이 사전 순으로 뒤에 있으면 1 -> Collections.sort()는 o2를 o1 앞에 위치시킴
                    return o1.compareTo(o2);
                }

                // len = -1 -> o1을 o2 앞에 위치시킴
                // len = 1 -> o1을 o2 뒤에 위치시킴
                return len;
            }
        });

        // ※ HashSet<String> set = new HashSet<>(list);
        List<String> answer = list.stream().distinct().collect(Collectors.toList());

        for (String s : answer) {
            System.out.println(s);
        }

        br.close();
    }
}
