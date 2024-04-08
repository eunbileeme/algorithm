import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());
        int square = Integer.parseInt(st.nextToken());

        // 1. 원소를 저장할 리스트 초기화
        List<Integer> list = new ArrayList<>();

        // 2. 리스트에 A를 추가한다.
        list.add(num);

        while (true) {
            // 3. 리스트에 저장된 값 중, 가장 마지막에 추가된 원소를 가져온다.
            int tmp = list.get(list.size() - 1);

            // 4. 이번 턴에 구할 원소 (즉, 이전 값으로부터 다음 원소)
            int result = 0;
            // 5. tmp 원소의 각 자릿수를 다 쪼갤 때가지, p 제곱만큼을 누적시킴
            while (tmp != 0) {
                result += (int) Math.pow(tmp % 10, (double) square);
                // 6. 남은 자릿수를 tmp에 누적시킨다.
                tmp /= 10;
            }

            // 7. 구한 원소가 list에 있다면
            if (list.contains(result)) {
                // 7-1. 해당 원소의 인덱스를 반환하여 개수를 구함
                int cnt = list.indexOf(result);
                System.out.println(cnt);
                break;
            }

            // 7-2. 없었다면, 리스트에 누적시켜 같은 원소가 나올 때까지 ..
            list.add(result);
        }

        br.close();
    }
}
