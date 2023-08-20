import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // ※ n = 1, h = 1, w = 12, person = 2
        for (int i = 0; i < n; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int person = Integer.parseInt(st.nextToken());

            int width = (person - 1) / h + 1;
            int height = (person - 1) % h + 1;

            System.out.println(height * 100 + width);
        }

        br.close();
    }
}