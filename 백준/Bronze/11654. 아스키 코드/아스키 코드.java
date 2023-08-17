import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ※ ASCII : String -> char -> int
        char a = br.readLine().charAt(0);

        System.out.println((int) a);
        br.close();
    }
}