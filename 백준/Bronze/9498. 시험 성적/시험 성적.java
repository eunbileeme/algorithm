import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int score = Integer.parseInt(st.nextToken());

        if (score >= 90 && score <= 100)
            System.out.println("A");
        else if (score >= 80 && score <= 89)
            System.out.println("B");
        else if (score >= 70 && score <= 79)
            System.out.println("C");
        else if (score >= 60 && score <= 69)
            System.out.println("D");
        else
            System.out.println("F");

        br.close();
    }
}