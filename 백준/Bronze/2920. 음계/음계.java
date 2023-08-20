import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // ※ Integer.parseInt(st.nextTokens()) == 8 && ..으로 하나씩 비교했을 때, if문에서 조건 검사를 하느라 주어진 토큰을 다 씀
        // 따라서 else if문에 사용할 토큰이 더이상 남아있지 않으므로 조건 검사를 할 수 없음
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[8];

        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (arr[0] == 1 && arr[1] == 2 && arr[2] == 3 && arr[3] == 4 &&
                arr[4] == 5 && arr[5] == 6 && arr[6] == 7 && arr[7] == 8) {
            System.out.println("ascending");
        } else if (arr[0] == 8 && arr[1] == 7 && arr[2] == 6 && arr[3] == 5 &&
                arr[4] == 4 && arr[5] == 3 && arr[6] == 2 && arr[7] == 1) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }

        br.close();
    }
}