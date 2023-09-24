import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while(!(str = br.readLine()).equals("0")) {
            if (str.length() % 2 == 1) {
                if (str.length() == 1) {
                    sb.append("yes").append('\n');
                    continue;
                }

                if (str.length() == 3) {
                    if (str.charAt(0) == str.charAt(2)) {
                        sb.append("yes").append('\n');
                    }
                    else {
                        sb.append("no").append('\n');
                    }
                } else {
                    if (str.charAt(0) == str.charAt(4) && str.charAt(1) == str.charAt(3)) {
                        sb.append("yes").append('\n');
                    }
                    else {
                        sb.append("no").append('\n');
                    }
                }
            } else {
                if (str.length() == 2) {
                    if (str.charAt(0) == str.charAt(1)) {
                        sb.append("yes").append('\n');
                    }
                    else {
                        sb.append("no").append('\n');
                    }
                } else {
                    if (str.charAt(0) == str.charAt(3) && str.charAt(1) == str.charAt(2)) {
                        sb.append("yes").append('\n');
                    }
                    else {
                        sb.append("no").append('\n');
                    }
                }
            }
        }

        System.out.println(sb);

        br.close();
    }
}