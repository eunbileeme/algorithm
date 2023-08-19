import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        int cnt = 1;

        for (int i = 0; i < arr.length; i ++) {
            arr[i] = Integer.parseInt(br.readLine()) % 42;
        }

        Arrays.sort(arr);

        for (int j = 1; j <= arr.length - 1; j ++) {
            if (arr[j] != arr[j - 1]) {
                cnt ++;
            }
        }

        System.out.println(cnt);

        br.close();
    }
}