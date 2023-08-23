import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 1; // 바퀴 수 ex. 1바퀴(2 ~ 7) -> 2바퀴(8 ~ 19) -> ..
        int range = 2;	// 범위의 시작 번호 ex. 2 -> 8 -> 20..

        if (N == 1) {
            System.out.print(1);
        }

        else {
            while (range <= N) {
                range = range + (6 * count);
                count++;
            }
            System.out.print(count);
        }
    }
}