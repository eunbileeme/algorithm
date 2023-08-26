import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // ※ n은 행
        int[][] arr = new int[n][2];

        /*
        int[][] array = {
                {1, 4},
                {3, 2},
                {5, 1},
                {4, 3}
        };
        */
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // ※ x 값이 같을 경우에만 y값을 비교하여 더 작은 값(= -1)을 기준으로 정렬
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                else return Integer.compare(o1[0], o2[0]);
            }
        });

        for (int i = 0; i < n; i ++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }

        br.close();
    }
}