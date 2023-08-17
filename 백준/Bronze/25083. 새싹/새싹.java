import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("         ,r'\"7\n" +
                "r`-_   ,'  ,/\n" +
                " \\. \". L_r'\n" +
                "   `~\\/\n" +
                "      |\n" +
                "      |");
        bw.flush();
        br.close();
    }
}