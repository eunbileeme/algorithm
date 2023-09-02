import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // ※ 2차원 배열로 할지, HashMap으로 할지 고민하다가 이도저도 아니게 된 문제..
        int[][] arr = new int[n][2];

        String[] sp;
        for (int i = 0; i < n; i ++) {
            sp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(sp[0]); // 키
            arr[i][1] = Integer.parseInt(sp[1]); // 몸무게
        }

        for (int i = 0; i < n; i ++) {
            int rank = 1;
            for (int j = 0; j < n; j ++) {
                if (i == j) continue;
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank ++;
                }
            }

            System.out.print(rank + " ");
        }
    }
}