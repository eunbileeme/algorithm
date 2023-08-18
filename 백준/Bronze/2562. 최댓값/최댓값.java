import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int max = 0;
        // ※ 최댓값의 원래 위치를 출력해야 함 -> 위치를 보관할 변수 필요
        int index = 0;

        for (int i = 0; i < arr.length; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }

        System.out.println(max);
        System.out.println(index + 1);

        br.close();
    }
}