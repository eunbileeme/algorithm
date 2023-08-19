import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int answer = 0;

        // ※ 오전 12시 + 45분 이상일 경우, 동일하게 시간은 오전 12시 - 즉 0시로 나와야 한다.
        // ※ 즉, 12시 + 45분을 분기로 둬야 한다.
        if (hour == 0 && minute >= 45) {
            answer = (12 * 60 + minute) - 45;
            System.out.print((answer / 60) - 12 + " " + answer % 60);
        } else if (hour == 0 && minute < 45) {
            answer = (12 * 60 + minute) - 45;
            System.out.print((answer / 60) + 12 + " " + answer % 60);
        } else {
            answer = (hour * 60 + minute) - 45;
            System.out.print(answer / 60 + " " + answer % 60);
        }

        br.close();
    }
}