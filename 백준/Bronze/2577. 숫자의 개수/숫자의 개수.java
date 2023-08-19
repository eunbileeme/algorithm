import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        int sum = 1;

        for (int i = 0; i < arr.length; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum *= arr[i];
        }

        String stringSum = String.valueOf(sum);
        int[] cnt = new int[10];

        for (int i = 0; i < stringSum.length(); i ++) {
            if ('0' == stringSum.charAt(i)) // arr[(str.charAt(i) - '0')]++;
                cnt[0] ++;
            else if ('1' == stringSum.charAt(i))
                cnt[1] ++;
            else if ('2' == stringSum.charAt(i))
                cnt[2] ++;
            else if ('3' == stringSum.charAt(i))
                cnt[3] ++;
            else if ('4' == stringSum.charAt(i))
                cnt[4] ++;
            else if ('5' == stringSum.charAt(i))
                cnt[5] ++;
            else if ('6' == stringSum.charAt(i))
                cnt[6] ++;
            else if ('7' == stringSum.charAt(i))
                cnt[7] ++;
            else if ('8' == stringSum.charAt(i))
                cnt[8] ++;
            else
                cnt[9] ++;
        }

        for (int i = 0; i < cnt.length; i ++) {
            System.out.println(cnt[i]);
        }

        br.close();
    }
}
