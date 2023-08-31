import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
        
        System.out.println(getValue(m, 0, arr[n - 1], arr));
        br.close();
    }

    private static int getValue(int budget, int min, int max, int[] arr) {
        int l = min; int r = max; // l : 상한액의 최솟값, r : 상한액의 최댓값

        while (l <= r) {
            int m = l + (r - l) / 2; // m : 현재 검사하는 상한액
            int sum = 0;
            
            for (int i : arr) {
                sum += (i < m) ? i : m;
            }

            if (sum > budget) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l - 1;
    }
}
