import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {

            int index = str.charAt(i) - 'A';
            arr[index]++;
        }
        
        int odd = 0;
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                odd++;
                num = i;
            }
            if (odd >= 2) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i] / 2; j++) {
                sb.append((char)(i+'A'));
            }
        }
        
        String result = sb.toString();
        if (odd == 1) {
            result += (char) (num + 'A');
        }
        
        result += sb.reverse().toString();
        System.out.println(result);

        br.close();
    }
}