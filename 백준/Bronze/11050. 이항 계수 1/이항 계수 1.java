import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int nSum = 1;
        for (int i = n; i > 0; i --) {
            nSum *= i;
        }

        int kSum = 1;
        for (int i = k; i > 0; i --) {
            kSum *= i;
        }

        int nkSum = 1;
        for (int i = n - k; i > 0; i --) {
            nkSum *= i;
        }

        System.out.println(nSum / (kSum * nkSum));

        br.close();
    }
}