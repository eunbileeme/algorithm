import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int criteria = Integer.parseInt(br.readLine());

        // 1. 다솜이가 매수해야할 사람의 최솟값 변수를 초기화
        int cnt = 0;

        // TODO 다솜이만 출마했을 때
        if (n == 1) {
            System.out.println(cnt);
            return;
        }

        // 2. 기호 1번을 제외한 나머지 후보자들의 득표수를 담는다.
        int[] arr = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 3. 정렬한다.
        Arrays.sort(arr);

        // TODO 다솜이가 다른 후보자보다 많은 득표수를 가지고 있을 때
        if (criteria > arr[arr.length - 1]) {
            System.out.println(cnt);
            return;
        }

        // 4. 가장 많은 득표수를 가진 후보자와 비교하여, 다솜이의 득표수가 후보자의 득표수보다 적을 때까지 반복
        // TODO for문으로 반복할 경우, 아직 다솜이보다 득표수가 많은 후보자가 남아있음에도 불구하고 순회가 끝나면 멈춤
        while (criteria <= arr[arr.length - 1]) {
            // 5. 가장 큰 득표수를 가진 후보자의 득표수에서 가져온다.
            criteria += 1;
            arr[arr.length - 1] -= 1;
            cnt++;// 5. 가장 많은 득표수를 가진 후보자와 비교

            Arrays.sort(arr);
        }

        // 6. 출력
        System.out.println(cnt);
        br.close();
    }
}
