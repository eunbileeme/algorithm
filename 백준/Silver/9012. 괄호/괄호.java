import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
            int cnt = 0;
            
            for (int j = 0; j < str[i].length(); j++) {
                if (cnt < 0) break;
                
                if (str[i].charAt(j) == '(') {
                    cnt++;
                } else if (str[i].charAt(j) == ')') cnt--;
            }
            
            if (cnt == 0) System.out.println("YES");
            else if ((cnt > 0) || (cnt < 0)) System.out.println("NO");
        }

        br.close();
    }
}
