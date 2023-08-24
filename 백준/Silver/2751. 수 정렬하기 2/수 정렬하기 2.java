import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// ※ 입력값 자체에 중복된 값이 들어오지 않음
// ※ sout 자체도 시간 자체가 꽤 걸림 -> bw 혹은 sb를 사용하여 출력할 것
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i ++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        // ※ 시간 복잡도 : O(nlogn) 또는 O(n)
        Collections.sort(list);

        for (int i : list) {
            sb.append(i).append('\n');
        }

        System.out.println(sb);

        br.close();
    }
}